package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO 
{
	public MemoDAO() throws ClassNotFoundException 
	{
		Class.forName(DBInfo.DRIVER);
	}

	public void insertMemo(MemoVO mvo) throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("insert into memo values(memo_seq.nextval, ? ,?)");
			pstmt.setString(1, mvo.getTitle());
			pstmt.setString(2, mvo.getContent());
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}

	public ArrayList<MemoVO> getAllMemoList() throws SQLException 
	{
		ArrayList<MemoVO> list = new ArrayList<MemoVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select * from memo order by memo_no desc");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(new MemoVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(pstmt != null)
		{
			pstmt.close();
		}
		
		if(con != null)
		{
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(rs != null)
		{
			rs.close();
		}
		
		closeAll(pstmt, con);
	}
}
