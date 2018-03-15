package step2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestInput 
{
	public static void main(String[] args) 
	{
		
		try 
		{
			// 파일에 연결되는 입력 Node Stream
			FileReader fr = new FileReader("C:\\java-kosta\\test\\점심 메뉴.txt");
	
			// 입력 Processing Stream
			BufferedReader br = new BufferedReader(fr);
			
			// 한 라인씩 입력
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());   // 더 이상 입력받을 내용이 없으면 null을 반환
			br.close();
			System.out.println("입력 작업 완료!");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
