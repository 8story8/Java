package step6;

import java.io.IOException;

public class TestCopyAndPasteDir2 
{
	public static void main(String[] args) 
	{
		FileService service = new FileService();
		String orgDir = "C:\\java-kosta\\test\\iotest\\document";
		String destFile = "C:\\java-kosta\\test\\iotest2\\report2\\���ǽ� ���ΰ�.txt";
		
		try 
		{
			service.copyAndPasteDir(orgDir, destFile);
			System.out.println("���� �Ϸ�~");
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
