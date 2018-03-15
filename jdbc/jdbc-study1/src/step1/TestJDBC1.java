package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC1 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Loading Complete");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			System.out.println("Oracle DB Connection Complete");
			
			PreparedStatement pstmt =  con.prepareStatement("select * from member order by id asc");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4));
			}
			
			rs.close();
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
