package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC2 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");   
			System.out.println("Oracle Driver Loading Complete");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			System.out.println("Oracle DB Connection Complete");
			
			PreparedStatement pstmt = con.prepareStatement("insert into member(id, password, name, address) values(?, ?, ?, ?)");
			
			pstmt.setString(1, "왕");
			pstmt.setString(2, "fn2vl16");
			pstmt.setString(3, "문성준");
			pstmt.setString(4, "분당");
			
			int result = pstmt.executeUpdate();
			System.out.println("insert count : " + result);
			
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
