package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountNotFoundException;
import model.NoMoneyException;

// step3 �Ա� �׽�Ʈ 

public class TestUnit3 
{
	public static void main(String[] args) 
	{		
		try 
		{
			AccountDAO dao = new AccountDAO();
			dao.deposit("3", 2000);
			System.out.println("���� �Ա� ó���Ǿ����ϴ�!");
		}
		catch (AccountNotFoundException anfe) 
		{				
			System.out.println(anfe.getMessage());			
		}
		catch (NoMoneyException nme) 
		{			
			System.out.println(nme.getMessage());	
		}
		catch (SQLException sqle) 
		{		
			sqle.printStackTrace();
		}
		catch (ClassNotFoundException cnfe) 
		{			
			cnfe.printStackTrace();	
		}
	}
}
