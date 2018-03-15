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
		
		al.add("������");
		al.add("�����");
		al.add("����");
		al.add("�����");
		
		try 
		{
			service.writeList(al);
			System.out.println(path + " ���� �Ϸ�");
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
