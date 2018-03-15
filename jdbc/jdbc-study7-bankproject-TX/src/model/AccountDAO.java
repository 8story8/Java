package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBInfo;

public class AccountDAO 
{
	public AccountDAO() throws ClassNotFoundException 
	{
		Class.forName(DBInfo.DRIVER);
	}
	
	public void createAccount(AccountVO avo) throws SQLException, CreateAccountException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement("insert into account values(account_seq.nextval, ?, ?, ?)");
			
			if(avo.getBalance() < 1000)
			{
				throw new CreateAccountException(avo.getBalance() + "���� �ʱ� ���Ծ� ���ǿ� �������� �ʽ��ϴ�!");
			}
			
			pstmt.setString(1, avo.getName());
			pstmt.setString(2, avo.getPassword());
			pstmt.setInt(3, avo.getBalance());
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(pstmt, con);
		}
	}
	
	public int selectBalance(String num, String password) throws SQLException, AccountLoginException 
	{
	    int balance = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select * from account where num = ? and password = ?");
			pstmt.setString(1, num);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				balance = rs.getInt(4);
			}
			else
			{
				throw new AccountLoginException("���¹�ȣ �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
			}
		}
		finally
		{
			closeAll(pstmt, con);
		}
		
		return balance;
	}

	@SuppressWarnings("resource")
	public void deposit(String num, int money) throws SQLException, NoMoneyException, model.AccountNotFoundException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			pstmt = con.prepareStatement("select * from account where num = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(!rs.next())
			{
				throw new model.AccountNotFoundException(num + " ���¹�ȣ�� �������� �ʽ��ϴ�!");
			}
			
			if(money <= 0)
			{
				throw new NoMoneyException("�ݾ��� Ʋ���ϴ�!");
			}
			
			pstmt = con.prepareStatement("update account set balance = balance + ? where num = ?");
			pstmt.setInt(1, money);
			pstmt.setString(2, num);
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(rs ,pstmt, con);
		}
	}
	
	public void withdraw(String num, String password, int money) throws SQLException, NoMoneyException, InsufficientBalanceException, AccountLoginException
	{
		int balance = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			
			balance = selectBalance(num, password);
			
			if(money <= 0)
			{
				throw new NoMoneyException("�ݾ��� Ʋ���ϴ�!");
			}
			
			pstmt = con.prepareStatement("update account set balance = balance - ? where num = ?");
			
			if(balance - money < 0)
			{
				throw new InsufficientBalanceException("�ܾ��� ������� �ʽ��ϴ�!");
			}
			
			pstmt.setInt(1, money);
			pstmt.setString(2, num);
			
			pstmt.executeUpdate();
		}
		finally
		{
			closeAll(rs ,pstmt, con);
		}
	}
	
	public void transfer(String sendNum, String sendPassword, String receiveNum , int money) throws SQLException, NoMoneyException, InsufficientBalanceException, AccountLoginException, AccountNotFoundException, AccountEqualException 
	{
		if(sendNum.equals(receiveNum))
		{
			throw new AccountEqualException("���¹�ȣ�� �����մϴ�!");
		}
		
		int balance = selectBalance(sendNum, sendPassword);
		
		if(money > balance)
		{
			throw new InsufficientBalanceException("�ܾ��� ������� �ʽ��ϴ�!");
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(DBInfo.URL, "scott", "tiger");
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement("update account set balance = balance - ? where num = ?");
			pstmt.setInt(1, money);
			pstmt.setString(2, sendNum);
			int withdrawResult = pstmt.executeUpdate();
			System.out.println("��ü ��� �۾� �Ϸ� : " + withdrawResult);
			
			pstmt.close();
			
			pstmt = con.prepareStatement("update account set balance = balance + ? where num = ?");
			pstmt.setInt(1, money);
			pstmt.setString(2, receiveNum);
			int depositResult = pstmt.executeUpdate();
			System.out.println("��ü �Ա� �۾� �Ϸ� : " + depositResult);
			
			// withdraw(sendNum, sendPassword, money);
			// deposit(receiveNum, money);

			con.commit();
			System.out.println("Commit : ���� DB�� ����!");
		}
		catch(Throwable t)
		{
			con.rollback();
			System.out.println("Rollback : �۾� ���!" );
			throw t;
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(pstmt != null)
		{
			pstmt.close();
		}
		
		if(con != null)
		{
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException
	{
		if(rs != null)
		{
			rs.close();
		}
		
		closeAll(pstmt, con);
	}
}
