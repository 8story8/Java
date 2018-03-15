package step2;

import java.io.IOException;

public class TestImageService 
{
	public static void main(String[] args) 
	{
		String orgPath = "C:\\java-kosta\\test\\원피스.jpg";
		String destPath = "C:\\java-kosta\\test\\image\\원피스.jpg";
		
		ImageService service = new ImageService();
		System.out.println("이미지 복붙 완료");
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
