package step2;

import java.io.IOException;

public class TestImageService 
{
	public static void main(String[] args) 
	{
		String orgPath = "C:\\java-kosta\\test\\���ǽ�.jpg";
		String destPath = "C:\\java-kosta\\test\\image\\���ǽ�.jpg";
		
		ImageService service = new ImageService();
		System.out.println("�̹��� ���� �Ϸ�");
		try 
		{
			service.copyAndPaste(orgPath, destPath);
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
}
