package test;

import java.sql.SQLException;

import model.CardDAO;

public class TestTransaction 
{
	public static void main(String[] args) 
	{
		try 
		{
			CardDAO dao = new CardDAO();
			dao.registerCard("tomcat", "jin", 2500);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
