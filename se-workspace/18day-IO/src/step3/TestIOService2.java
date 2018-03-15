package step3;

import java.io.IOException;
import java.util.ArrayList;

public class TestIOService2 
{
	public static void main(String[] args) 
	{
		String path = "C:\\java-kosta\\test\\iotest\\list.txt";
		IOService service = new IOService(path);
		
		try 
		{
			ArrayList<String> al = service.readList();
			
			for(int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i));   
			}
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
		
		/*
	   아이유
	   장기하
	   설현
	   김규익
	   */
	}
}
