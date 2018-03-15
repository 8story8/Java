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
	
	public ArrayList<BoardVO> getPostingList(PagingBean pagingBean) throws SQLException{
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT A.* FROM(");
			sql.append("SELECT row_number() over(order by no desc) rnum,no,title,writer,");
			sql.append("hits,to_char(time_posted,'YYYY.MM.DD') as time_posted ");
			sql.append("from board");
			sql.append(") A where rnum between ? and ?");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, pagingBean.getStartRowNumber());
			pstmt.setInt(2, pagingBean.getEndRowNumber());
			rs=pstmt.executeQuery();	
			while(rs.next()){					
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setHits(rs.getInt("hits"));
				vo.setTimePosted(rs.getString("time_posted"));
				list.add(vo);			
			}		
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	public void posting(BoardVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			pstmt=con.prepareStatement("select board_seq.nextval from dual");
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo.setNo(rs.getInt(1));
			}
			pstmt.close();
			pstmt=con.prepareStatement("insert into board(no,title,writer,password,content,time_posted) values(?,?,?,?,?,sysdate)");
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getPassword());
			pstmt.setString(5, vo.getContent());		
			pstmt.executeUpdate();							
		}finally{
			closeAll(rs,pstmt,con);
		}
	}	
    /**
     * Sequence 글번호로 게시물을 검색하는 메서드 
     * @param no
     * @return
     * @throws SQLException
     */
	public BoardVO getPostingByNo(int no) throws SQLException{
		BoardVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getConnection();
			pstmt=con.prepareStatement("select no,title,writer,content,to_char(time_posted,'YYYY.MM.DD HH24:MI:SS') as time_posted,hits from board where no=?");
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();		
			if(rs.next()){
				vo=new BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setHits(rs.getInt("hits"));
				vo.setTimePosted(rs.getString("time_posted"));
			}
			//System.out.println("dao getContent:"+vo);
		}finally{
			closeAll(rs,pstmt,con);
		}
		return vo;
	}	
	/**
	 * 조회수 증가 
	 * @param no
	 * @throws SQLException
	 */
	public void updateHit(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection(); 
			pstmt=con.prepareStatement("update board set hits=hits+1 where no=?");
			pstmt.setInt(1, no);	
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
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
	public boolean checkPassword(int no, String password) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			con=getConnection(); 
			String sql="select count(*) from board where no=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
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
	public void deletePosting(int no) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection(); 
			String sql="delete from board where no=?";
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
	public void updatePosting(BoardVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=getConnection();
			String sql="update board set title=?,writer=?,content=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getNo());		
			pstmt.executeUpdate();			
		}finally{
			closeAll(pstmt,con);
		}
	}
	
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}	
	
	/**
	 * 총 게시물 수를 조회하는 메서드 
	 * @return
	 * @throws SQLException 
	 */
	public int getTotalContent() throws SQLException{
		int totalContent = 0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=getConnection(); 
			String sql="select count(*) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				totalContent = rs.getInt(1);
			}
		}finally{
			closeAll(rs,pstmt,con);
		}
		
		return totalContent;
	}
	
}












