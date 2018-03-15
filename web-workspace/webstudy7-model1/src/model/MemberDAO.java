package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO : Data Access Object
// MemberDAO는 Web Application상에서 하나만 존재하면 된다.
// Singleton Pattern을 적용하여 외부에서 Object 생성하는 것을 방지하고,
// 한 번 생성한 객체를 공유하여 사용하게 한다.

public class MemberDAO 
{
	// Class Loading 시점에 단 한 번 Object를 생성하여 Method Area에 적재
	private static MemberDAO instance = new MemberDAO();
	
	// 외부에서 생성 못하게 private 처리
	private MemberDAO(){ }
	
	// 외부에 현재 Object Reference를 공유
	public static MemberDAO getInstance()
	{
		return instance;
	}
	
	public MemberVO findMember(String id) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		MemberVO vo = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select name, address from member where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				vo = new MemberVO(id, rs.getString(1), rs.getString(2));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
	
		return vo;
	}
	
	public int getMemberCount() throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement("select count(*) from member");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		
		return count;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException
	{
		closeAll(null, pstmt, con);
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(rs != null)
		{
			rs.close();
		}
		
		if(pstmt != null)
		{
			pstmt.close();
		}
		
		if(con != null)
		{
			con.close();
		}
	}
}
