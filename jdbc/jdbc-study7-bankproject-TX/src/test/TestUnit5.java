package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountEqualException;
import model.AccountLoginException;
import model.AccountNotFoundException;
import model.InsufficientBalanceException;
import model.NoMoneyException;

// step5 ���� ��ü �׽�Ʈ 

/**
 * ������ü �׽�Ʈ Ŭ����
 * @author kosta
 *
 */

public class TestUnit5 
{
	/**
	 * ������ü ��� �׽�Ʈ �� Ʈ����� ó�� �׽�Ʈ
	 * @param args
	 */
	
	public static void main(String[] args) 
	{		
			try 
			{
				AccountDAO dao = new AccountDAO();
				dao.transfer("1","1234","2",2000);
				System.out.println("��ü�� �Ϸ�Ǿ����ϴ�!");			
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
