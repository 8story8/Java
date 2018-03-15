package test;

import java.sql.SQLException;

import model.CardDAO;
import model.CardDAO2;

public class TestTransaction2 
{
	public static void main(String[] args) 
	{
		try 
		{
			CardDAO2 dao = new CardDAO2();
			dao.registerCard("tomcat", "jin", 2500);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			System.out.println("main");
			e.printStackTrace();
		}
	}
}
