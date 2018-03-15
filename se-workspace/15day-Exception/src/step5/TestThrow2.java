package step5;

import java.io.IOException;

class MemberDAO   // DAO : Data Access Object
{
	public void register(String info) throws IOException
	{
		if(info.equals(""))
		{   
			// 공란일때 IOException을 고의로 발생시키겠다.
			throw new IOException();
		}
		
		System.out.println("D");
		System.out.println(info + " 정보를 DB에 저장"); 
	}
}

class MemberService   // Service : Business Service
{
	public void register(String info) throws IOException
	{
		MemberDAO dao = new MemberDAO();
		dao.register(info);
		System.out.println("E");
	}
}

public class TestThrow2 
{
	public static void main(String[] args) 
	{
		MemberService service = new MemberService();
		
		try 
		{
			service.register("");       
			System.out.println("A");
		} 
		catch (IOException e) 
		{
			System.out.println("C");   
			e.printStackTrace();
		}
		System.out.println("B");
	}
}
