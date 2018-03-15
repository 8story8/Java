package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO dao=new BoardDAO();	
	private DataSource dataSource;
	private BoardDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance(){
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public ArrayList<BoardVO> getAllBoardList(PagingBean pagingBean) throws SQLException{
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			
			StringBuilder sql=new StringBuilder();
			sql.append("select b.*, m.mname from(");
			sql.append("select row_number() over(order by no desc) rnum, no, title, ");
			sql.append("hits, to_char(time_posted,'YYYY.MM.DD') as time_posted, mid ");
			sql.append("from mboard");
			sql.append(") b, mem m where rnum between ? and ? and b.mid = m.mid order by b.no desc");
			
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, pagingBean.getStartRowNumber());
			pstmt.setInt(2, pagingBean.getEndRowNumber());
			
			rs=pstmt.executeQuery();	
			
			while(rs.next()){					
				BoardVO bvo=new BoardVO();
				bvo.setNo(rs.getInt("no"));
				bvo.setTitle(rs.getString("title"));
				bvo.setMvo(new MemberVO(rs.getString("mname")));
				bvo.setHits(rs.getInt("hits"));
				bvo.setTimePosted(rs.getString("time_posted"));
				list.add(bvo);			
			}		
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	
	/**
	 * 총 게시물 수를 조회하는 메서드 
	 * @return
	 * @throws SQLException 
	 */
	public int getTotalBoardCount() throws SQLException{
		int totalBoardCount = 0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection(); 
			
			String sql="select count(*) from mboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				totalBoardCount = rs.getInt(1);
			}
		}
		finally
		{
			closeAll(rs,pstmt,con);
		}
		
		return totalBoardCount;
	}
	
	 /**
     * Sequence 글번호로 게시물을 검색하는 메서드 
     * @param no
     * @return
     * @throws SQLException
     */
	public BoardVO getBoardByNo(int no) throws SQLException{
		BoardVO bvo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try
		{
			con=getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select b.*, m.mname from(");
			sql.append("select no, title, ");
			sql.append("content, hits, to_char(time_posted,'YYYY.MM.DD') as time_posted, mid ");
			sql.append("from mboard");
			sql.append(") b, mem m where b.no = ? and b.mid = m.mid");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();		
			if(rs.next())
			{
				bvo=new BoardVO();
				bvo.setNo(rs.getInt("no"));
				bvo.setTitle(rs.getString("title"));
				bvo.setMvo(new MemberVO(rs.getString("mname")));
				bvo.setContent(rs.getString("content"));
				bvo.setHits(rs.getInt("hits"));
				bvo.setTimePosted(rs.getString("time_posted"));
			}
		}
		finally
		{
			closeAll(rs,pstmt,con);
		}
		
		return bvo;
	}	
	/**
	 * 조회수 증가 
	 * @param no
	 * @throws SQLException
	 */
	public void updateHit(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try
		{
			con=getConnection(); 
			pstmt=con.prepareStatement("update mboard set hits=hits+1 where no=?");
			pstmt.setInt(1, no);	
			pstmt.executeUpdate();			
		}
		finally
		{
			closeAll(pstmt,con);
		}
	}

	public void insertBoard(BoardVO bvo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			
			pstmt=con.prepareStatement("select board_seq.nextval from dual");
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				bvo.setNo(rs.getInt(1));
			}
			
			pstmt.close();
			
			pstmt=con.prepareStatement("insert into mboard(no, title, content, time_posted, mid) values(?, ?, ?, sysdate, ?)");
			pstmt.setInt(1, bvo.getNo());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getContent());
			pstmt.setString(4, bvo.getMvo().getId());
			
			pstmt.executeUpdate();							
		}
		finally
		{
			closeAll(rs,pstmt,con);
		}
	}	
	
	/**
	 * 게시물의 비밀번호가 일치하는 지 확인하는 메서드 
	 * 일치하면 true를 반환하고 일치하지 않으면 false를 반환한다.
	 * @param no
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean checkPassword(int no, String pass) throws SQLException {
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=getConnection(); 
			String sql="select count(*) from( ) mem where no=? and mpass=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)!=0)
					flag=true;
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		return flag;
	}
	
	/**
	 * 글번호에 해당하는 게시물을 삭제하는 메서드
	 * @param no
	 * @throws SQLException
	 */
	public void deleteBoard(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection(); 
			String sql="delete from mboard where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);		
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
		}
	}
	
	/**
	 * 게시물 정보 업데이트하는 메서드 
	 * @param vo
	 * @throws SQLException
	 */
	public void updateBoard(BoardVO bvo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update mboard set title = ?, content = ? where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNo());		
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
		}
	}
	
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
		{
			pstmt.close();
		}
	
		if(con!=null){
			con.close(); 
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException{
		if(rs!=null){
			rs.close();
		}
			
		closeAll(pstmt,con);
	}	
}
