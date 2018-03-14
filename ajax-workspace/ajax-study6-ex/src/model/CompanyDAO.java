package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

public class CompanyDAO {
	private DataSource dataSource;
	private static CompanyDAO instance = new CompanyDAO();
	private CompanyDAO(){
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static CompanyDAO getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	/**
	 * 사원번호리스트를 제공한다.
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<String> getEmpNoList() throws SQLException{
		ArrayList<String> list = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement("select e.empNo from emp_ex e, dept_ex d where e.deptno = d.deptno");
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}
		finally{
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	
	/**
	 * 사원번호로 사원과 사원의 부서정보를 조회하여 map으로 제공한다.
	 * @param empNo
	 * @return
	 * @throws SQLException 
	 */
	public HashMap<String, String> getEmpAndDeptInfo(String empNo) throws SQLException{
		HashMap<String, String> map = new HashMap<String, String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement("select e.ename, e.sal, d.dname, d.loc from (select empno, ename, sal, deptno from emp_ex) e, dept_ex d where e.deptno  = d.deptno and e.empno = ?");
			pstmt.setString(1, empNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				map.put("ename", rs.getString(1));
				map.put("sal", rs.getString(2));
				map.put("dname", rs.getString(3));
				map.put("loc", rs.getString(4));
			}
		}
		finally{
			closeAll(rs, pstmt, con);
		}
		return map;
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
