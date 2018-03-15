package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO2 
{
	public CardDAO2() throws ClassNotFoundException 
	{
		Class.forName(DBInfo.DRIVER);
	}

	/**
	 * 카드와 포인트 정보를 함께 DB에 저장하는 메서드
	 * 카드 등록
	 * 포인트 등록
	 * 위 두 가지 업무가 모두 정상적으로 수행되었을 때 실제 DB에 반영(commit)
	 * 만약 두 업무 중 하나라도 문제가 발생하면 모든 작업이 취소되도록 처리(rollback)
	 * try
	 * {
	 * 		Transaction 수동 모드로 변경
	 * 		카드 작업
	 * 		포인트 작업
	 * 		commit
	 * }
	 * catch()
	 * {
	 * 		rollback
	 * }
	 * @param id
	 * @param name
	 * @param point
	 * @throws SQLException
	 */
	public void registerCard(String id, String name, int point) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("insert into card values(?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int cardResult = pstmt.executeUpdate();
			System.out.println("card insert result : " + cardResult);
			
			pstmt.close();
			
			pstmt = con.prepareStatement("insert into point values(?,?)");
			pstmt.setString(1, id);
			int pointResult = pstmt.executeUpdate();
			System.out.println("point insert result : " + pointResult);
			con.commit();
			System.out.println("Commit : 카드와 포인트 등록 완료");
		}
		catch(Throwable t)
		{
			con.rollback();
			System.out.println("Rollback : 문제가 발생하여 원래 상태로 복구 완료");
			// Exception or Error 발생시 rollback 처리 후 다시 throws되도록 throw t를 명시한다.
			throw t;
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
