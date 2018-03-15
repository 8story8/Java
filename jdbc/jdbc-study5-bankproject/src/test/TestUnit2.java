package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountLoginException;

// step2 ���� �ܾ� ��ȸ �׽�Ʈ

public class TestUnit2 
{
	public static void main(String[] args) 
	{		
		try 
		{
			AccountDAO dao = new AccountDAO();
			System.out.println("�ܾ� ��ȸ : " + dao.selectBalance("2", "tkd2el16"));
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