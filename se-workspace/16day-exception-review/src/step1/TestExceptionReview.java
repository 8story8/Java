package step1;

import java.util.Scanner;

public class TestExceptionReview 
{
	/*
	���� ���� �Աݽ� �ݾ��� 0�� �����̸� InvalidMoneyException�� �߻���Ű��,
	ȣ���� ������ �ش� Exception�� �����ϴ� ����
	*/
	
	public static void main(String[] args) 
	{
		AccountService service = new AccountService();
		
		System.out.println("�Ա��� �ݾ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		
		try 
		{
			int money = Integer.parseInt(sc.nextLine());
			service.deposit(money);
			System.out.println("�Ա� �Ϸ� �� �۾�");
		} 
		catch(NumberFormatException ne)
		{
			System.out.println("�ݾ��� ���ڷ� �Է��ϼ���.");
		}		
		catch (InvalidMoneyException e) 
		{
			System.out.println(e.getMessage()); 
		}
		finally
		{
			sc.close();
		}
	}
}
