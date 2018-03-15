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
	 * ī��� ����Ʈ ������ �Բ� DB�� �����ϴ� �޼���
	 * ī�� ���
	 * ����Ʈ ���
	 * �� �� ���� ������ ��� ���������� ����Ǿ��� �� ���� DB�� �ݿ�(commit)
	 * ���� �� ���� �� �ϳ��� ������ �߻��ϸ� ��� �۾��� ��ҵǵ��� ó��(rollback)
	 * try
	 * {
	 * 		Transaction ���� ���� ����
	 * 		ī�� �۾�
	 * 		����Ʈ �۾�
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
			System.out.println("Commit : ī��� ����Ʈ ��� �Ϸ�");
		}
		catch(Throwable t)
		{
			con.rollback();
			System.out.println("Rollback : ������ �߻��Ͽ� ���� ���·� ���� �Ϸ�");
			// Exception or Error �߻��� rollback ó�� �� �ٽ� throws�ǵ��� throw t�� ����Ѵ�.
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
