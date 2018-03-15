package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountVO;
import model.CreateAccountException;

// step1. ���� ���� ���� �׽�Ʈ 

public class TestUnit1 
{
	public static void main(String[] args)
	{
		try
		{
			AccountDAO dao=new AccountDAO();			
			AccountVO vo=new AccountVO("Z","1234567",3000);   // ������ ���� ����
			
			try
			{
				dao.createAccount(vo);
				System.out.println("���� ���� ����");
			}
			catch(CreateAccountException cae)
			{
				System.out.println(cae.getMessage());
			}			
		}
		catch (ClassNotFoundException cnfe) 
		{			
			cnfe.printStackTrace();
		} 
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
}













