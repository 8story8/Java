package step8;

import java.util.Scanner;

public class TestUserDefinedException2 
{
	public static void main(String[] args) 
	{
		System.out.println("�г����� �Է��ϼ���(2�� �̻� 5�� ���ϸ� ��� ����)");
		
		Scanner sc = new Scanner(System.in);
		
		String nickName = sc.nextLine();
		
		MemberService service = new MemberService();
		
		try
		{
			service.register(nickName);
		}
		catch(NickNameException e)
		{
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
