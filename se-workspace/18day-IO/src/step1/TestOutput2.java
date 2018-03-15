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
			System.out.println("**점심 메뉴**");
			
			Scanner sc = new Scanner(System.in);
			FileWriter fw = new FileWriter("C:\\java-kosta\\test\\점심 메뉴.txt", true);
			PrintWriter pw = new PrintWriter(fw, true);   // true : auto-flush
			
			while(true)
			{
				String menu = sc.nextLine();
			
				if(menu.equals("주문끝"))
				{
					System.out.println("주문이 완료되었습니다.");
					pw.close();   // flush(Buffer에 있는 데이터를 출력) 후 스트림을 닫는다.
					sc.close();
					break;
				}
				
				System.out.println(menu + " 주문!");
				pw.println(menu);
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
}

