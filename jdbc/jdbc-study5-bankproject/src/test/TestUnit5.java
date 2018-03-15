package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountEqualException;
import model.AccountLoginException;
import model.AccountNotFoundException;
import model.InsufficientBalanceException;
import model.NoMoneyException;

// step5 계좌 이체 테스트 

public class TestUnit5 
{
	public static void main(String[] args) 
	{		
			try 
			{
				AccountDAO dao = new AccountDAO();
				dao.transfer("2","tkd2el16","2",1000);
				System.out.println("이체 완료");			
			} 
			catch (ClassNotFoundException cnfe) 
			{				
				cnfe.printStackTrace();
			} 
			catch (NoMoneyException nme)
			{
				System.out.println(nme.getMessage());
			} 
			catch (SQLException sqle) 
			{				
				sqle.printStackTrace();
			} 
			catch (AccountNotFoundException anfe) 
			{
				System.out.println(anfe.getMessage());
			} 
			catch (InsufficientBalanceException ibe) 
			{
				System.out.println(ibe.getMessage());
			} 
			catch (AccountLoginException ale) 
			{
				System.out.println(ale.getMessage());
			} 
			catch (AccountEqualException aee) 
			{
				System.out.println(aee.getMessage());
			}				
	}
}
