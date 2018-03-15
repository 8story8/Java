package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountLoginException;
import model.InsufficientBalanceException;
import model.NoMoneyException;

// step4 출금 테스트 

public class TestUnit4 
{
	public static void main(String[] args) 
	{		
		try 
		{
			AccountDAO dao = new AccountDAO();
			dao.withdraw("3","fn2vl16", 1000000);
			System.out.println("정상 출금 처리되었습니다!");				
		}
		catch (NoMoneyException nme) 
		{			
			System.out.println(nme.getMessage());	
		}
		catch (AccountLoginException ale) 
		{				
			System.out.println(ale.getMessage());		
		}
		catch (InsufficientBalanceException ibe) 
		{
			System.out.println(ibe.getMessage());	
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
