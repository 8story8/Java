package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
DAO : Data Access Object
DB 연동을 위한 객체
*/

public class MemberDAO 
{	
	public MemberDAO() throws ClassNotFoundException 
	{
		Class.forName(DBInfo.DRIVER);
	}
	
	public MemberVO findMemberById(String id) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		MemberVO vo = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select password, name, address from member where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
	
		return vo;
	}

	public void registerMember(MemberVO vo) throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
		
			pstmt = con.prepareStatement("insert into member values(?, ? ,? ,?)");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public void updateMember(MemberVO vo) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("update member set password = ?, name = ?, address = ? where id = ?");
			
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<MemberVO> getAllMemberList() throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select * from member order by id asc");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberVO vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				al.add(vo);
			}
			
			return al;
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
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

	public int getMemberCountByAddress(String address) throws SQLException 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement("select count(*) from member where address = ?");
			pstmt.setString(1, address);
			
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
}
