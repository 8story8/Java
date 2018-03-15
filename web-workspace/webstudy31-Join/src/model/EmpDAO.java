package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class EmpDAO {
	private static EmpDAO dao=new EmpDAO();	
	private DataSource dataSource;
	private EmpDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static EmpDAO getInstance(){
		return dao;
	}
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public ArrayList<EmpVO> getEmpList() throws SQLException{
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			
			StringBuilder sql=new StringBuilder();
			sql.append("select e.empno, e.ename, d.dname, d.loc from emp_ex e, dept_ex d where e.deptno = d.deptno order by e.empno desc");
			pstmt=con.prepareStatement(sql.toString());	
			rs=pstmt.executeQuery();	
			while(rs.next()){					
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getString("empno"));
				evo.setEname(rs.getString("ename"));
				DeptVO dvo = new DeptVO();
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				evo.setDeptVO(dvo);
				list.add(evo);			
			}		
		}finally{
			closeAll(rs,pstmt,con);
		}
		return list;
	}
	
	public EmpVO findEmpByNo(String empNo) throws SQLException{
		EmpVO evo = null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			
			StringBuilder sql=new StringBuilder();
			sql.append("select e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc, d.tel from emp_ex e, dept_ex d where empno = ? and e.deptno = d.deptno");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setString(1, empNo);
			rs=pstmt.executeQuery();	
			while(rs.next()){					
				evo = new EmpVO();
				evo.setEmpno(rs.getString(1));
				evo.setEname(rs.getString(2));
				evo.setSalary(rs.getInt(3));
				evo.setDeptVO(new DeptVO(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));			
			}		
		}finally{
			closeAll(rs,pstmt,con);
		}
		return evo;
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












