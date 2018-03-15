package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource;

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static MemberDAO getInstance() throws ClassNotFoundException {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public MemberVO login(String id, String pass) throws SQLException {
		MemberVO mvo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			con = getConnection();
			
			String sql = "select mname from mem where mid=? and mpass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				mvo = new MemberVO(id, pass, rs.getString("mname"));
			} 
		finally 
		{
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
		{
			pstmt.close();
		}
		
		if (con != null)
		{
			con.close();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
		{
			rs.close();
		}
		
		closeAll(pstmt, con);
	}
}
