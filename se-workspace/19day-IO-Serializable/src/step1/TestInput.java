package step1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 1byte 단위 입력 스트림을 이용
public class TestInput 
{
	public static void main(String[] args)
	{
		try 
		{
			FileInputStream fis = new FileInputStream("C:\\java-kosta\\test\\output.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// bis.read();   // int형으로 반환, 더 읽을 내용이 없으면 -1을 반환
			int data = -1;
			
			while((data = bis.read()) != -1)
			{
				System.out.println((char) data);
			}
	
			bis.close();
		} 
		catch (FileNotFoundException fe) 
		{
			fe.printStackTrace();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
