package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestOutput 
{
	public static void main(String[] args) 
	{
		try 
		{
			// 파일에 연결되는 Node Stream : 파일이 없으면 생성
			// 두 번째 Parameter값 true는 append
			FileWriter fw = new FileWriter("C:\\java-kosta\\test\\memo.txt", true);
			
			// 문자열을 출력하기 위한 Processing Stream
			PrintWriter pw = new PrintWriter(fw);
			pw.println("방가방가 IO");
			System.out.println("작업 완료");
			pw.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
