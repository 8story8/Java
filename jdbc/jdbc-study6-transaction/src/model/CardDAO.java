package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO 
{
	public CardDAO() throws ClassNotFoundException 
	{
		Class.forName(DBInfo.DRIVER);
	}

	/**
	 * �Ʒ� �޼���� ī�� �߱޽� �ݵ�� ����Ʈ�� ���޵Ǿ�� �ϴ� �������� 
	 * ī�常 �߱޵ǰ� ����Ʈ ���� �������� ������ �߻��Ͽ�,
	 * DB�� ī�� ������ insert, ����Ʈ ������ insert���� ���� ����
	 * --> �̷� ��쿡�� ������ Transaction ó���� �ʿ��ϴ�.
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
			
			pstmt = con.prepareStatement("insert into card values(?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int cardResult = pstmt.executeUpdate();
			System.out.println("card insert result : " + cardResult);
			
			pstmt.close();
			
			pstmt = con.prepareStatement("insert into point values(?,?)");
			pstmt.setString(1, id);
			pstmt.setInt(2, point);
			int pointResult = pstmt.executeUpdate();
			System.out.println("point insert result : " + pointResult);
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
