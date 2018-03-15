package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO 
{
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO(){ }
	public static MemberDAO getInstance()
	{
		return dao;
	}

	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
	}
	
	public MemberVO findMemberById(String id) throws SQLException
	{
		MemberVO mvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement("select name, address from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				mvo = new MemberVO(id, rs.getString(1), rs.getString(2));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}
	
	public ArrayList<MemberVO> findMemberByAddress(String addr) throws SQLException
	{
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement("select id, name from member where address = ?");
			pstmt.setString(1, addr);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(new MemberVO(rs.getString(1), rs.getString(2)));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public MemberVO login(String id, String pw) throws SQLException
	{
		MemberVO mvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement("select * from member where id = ? and password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				mvo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3),  rs.getString(4));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}
	
	public boolean updateMember(String id, String pw, String name, String addr) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		boolean flag = false;
	
		if(pw != "" || name != "" || addr != "")
		{
			try
			{
				flag = true;
				con = getConnection();

				pstmt = con.prepareStatement("update member set password = ?, name = ?, address = ? where id = ?");
				pstmt.setString(1, pw);
				pstmt.setString(2, name);
				pstmt.setString(3, addr);
				pstmt.setString(4, id);
				pstmt.executeUpdate();
			}
			finally
			{
				closeAll(pstmt, con);
			}
		}
		return flag;
	}
	
	public boolean checkId(String id) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement("select id from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
		}
		finally
		{
			closeAll(pstmt, con);
		}
		
		return flag;
	}
	
	public void registerMember(MemberVO mvo) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;

		try
		{
			con = getConnection();
			pstmt = con.prepareStatement("insert into member values(?, ?, ?, ?)");
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getAddr());
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(pstmt != null)
		{
			pstmt.close();
		}
		
		if(con != null)
		{
			pstmt.close();
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
