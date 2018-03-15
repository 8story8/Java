package step8;

import java.util.Scanner;

public class TestUserDefinedException2 
{
	public static void main(String[] args) 
	{
		System.out.println("닉네임을 입력하세요(2자 이상 5자 이하만 등록 가능)");
		
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
