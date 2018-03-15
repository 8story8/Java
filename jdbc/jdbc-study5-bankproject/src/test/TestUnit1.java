package test;

import java.sql.SQLException;
import model.AccountDAO;
import model.AccountVO;
import model.CreateAccountException;

// step1. 계좌 개설 단위 테스트 

public class TestUnit1 
{
	public static void main(String[] args)
	{
		try
		{
			AccountDAO dao=new AccountDAO();			
			AccountVO vo=new AccountVO("Z","1234567",3000);   // 개설할 계좌 정보
			
			try
			{
				dao.createAccount(vo);
				System.out.println("계좌 개설 성공");
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













