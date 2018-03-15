package step5;

import java.io.IOException;

public class TestSerialService2 
{
	public static void main(String[] args) 
	{
		String path = "C:\\java-kosta\\test\\serial\\member.obj";
		
		SerialService service = new SerialService(path);
		
		try 
		{
			MemberVO mvo = service.readMemberVO();
			
			System.out.println(mvo.getId());
			System.out.println(mvo.getPassword());
			System.out.println(mvo.getName());
			System.out.println(mvo.getAddress());
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}
	}
}
