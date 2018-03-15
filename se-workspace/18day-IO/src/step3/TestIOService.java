package step3;

import java.io.IOException;
import java.util.ArrayList;

public class TestIOService 
{
	public static void main(String[] args) 
	{
		String path = "C:\\java-kosta\\test\\iotest\\list.txt";
		IOService service = new IOService(path);
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("아이유");
		al.add("장기하");
		al.add("설현");
		al.add("김규익");
		
		try 
		{
			service.writeList(al);
			System.out.println(path + " 저장 완료");
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
