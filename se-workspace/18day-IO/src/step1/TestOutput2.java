package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestOutput2 
{
	public static void main(String[] args) 
	{
		try 
		{
			System.out.println("**���� �޴�**");
			
			Scanner sc = new Scanner(System.in);
			FileWriter fw = new FileWriter("C:\\java-kosta\\test\\���� �޴�.txt", true);
			PrintWriter pw = new PrintWriter(fw, true);   // true : auto-flush
			
			while(true)
			{
				String menu = sc.nextLine();
			
				if(menu.equals("�ֹ���"))
				{
					System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�.");
					pw.close();   // flush(Buffer�� �ִ� �����͸� ���) �� ��Ʈ���� �ݴ´�.
					sc.close();
					break;
				}
				
				System.out.println(menu + " �ֹ�!");
				pw.println(menu);
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}

