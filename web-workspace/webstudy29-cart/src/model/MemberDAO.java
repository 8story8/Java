package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

// Data Access Logic Object
/*  MemberDAO는 웹어플리케이션 상에서 하나만 존재하면 된다
 *  Singleton Pattern을 적용하여 
 *  외부에서 객체생성하는 것을 막고 
 *  한번 생성한 객체를 공유하여 사용하게 한다 
 */
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

	public MemberVO findMemberById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			con = getConnection();
			String sql = "select password,name,address from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}


	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select name,address from member where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				vo = new MemberVO(id, password, rs.getString(1), rs.getString(2));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
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
