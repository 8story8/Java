package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC3 
{
	public static void main(String[] args) 
	{
		try 
		{
			// 조로 name인 member의 address를 서울로 업데이트
			String name = "조로";
			String address = "서울";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Loading Complete");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			System.out.println("Oracle DB Connection Complete");
			
			PreparedStatement pstmt = con.prepareStatement("update member set address = ? where name = ?");
			// PreparedStatement pstmt = con.prepareStatement("update member set address = '시부야' where name = '조로'");
			pstmt.setString(1, address);
			pstmt.setString(2, name);
			
			int result = pstmt.executeUpdate();
			System.out.println("update count : " + result);
			
			pstmt.close();
			con.close();
		} 
		catch (ClassNotFoundException ce) 
		{
			ce.printStackTrace();
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
}
