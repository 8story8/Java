package step5;

import java.io.IOException;

public class TestCopyAndPasteDir 
{
	public static void main(String[] args) 
	{
		FileService service = new FileService();
		String orgDir = "C:\\java-kosta\\test\\iotest\\document";
		String destDir = "C:\\java-kosta\\test\\iotest2\\report";
		
		try 
		{
			service.copyAndPasteDir(orgDir, destDir);
			System.out.println("���� �Ϸ�~");
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
