package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

/**
 * DAO에서 DBCP를 사용하는 예제
 * @author kosta
 *
 */

public class CarDAO {
	private static CarDAO dao = new CarDAO();
	private DataSource dataSource;
	
	private CarDAO(){
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	
	public static CarDAO getInstance(){
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		// Connection을 생성하는 것이 아니라 Connection을 DBCP로부터 빌려온다.
		return dataSource.getConnection();
	}
	
	public ArrayList<CarVO> getAllCarList() throws SQLException{
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement("select * from car");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new CarVO(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		}
		finally{
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException{
		if(pstmt != null){
			pstmt.close();
		}
		
		if(con != null){
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException{
		if(rs != null){
			rs.close();
		}
		
		closeAll(pstmt, con);
	}
}
