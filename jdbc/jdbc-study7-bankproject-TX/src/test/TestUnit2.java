package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountLoginException;

// step2 °èÁÂ ÀÜ¾× Á¶È¸ Å×½ºÆ®

public class TestUnit2 
{
	public static void main(String[] args) 
	{		
		try 
		{
			AccountDAO dao = new AccountDAO();
			System.out.println("ÀÜ¾× Á¶È¸ : " + dao.selectBalance("2", "tkd2el16"));
		}
		catch (AccountLoginException ale) 
		{			
			System.out.println(ale.getMessage());			
		} 
		catch (ClassNotFoundException cnfe) 
		{
			cnfe.printStackTrace();
		} 
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}
	}
}