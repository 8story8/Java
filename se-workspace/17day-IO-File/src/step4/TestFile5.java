package step4;

import java.io.IOException;

public class TestFile5 
{
	public static void main(String[] args) 
	{
		FileService service = new FileService();
		String dir = "C:\\java-kosta\\test\\media2";
		String info = "좋다고 말해.mp3,첫눈처럼 너에게 가겠다.mp3,너의 이름은.mp4,라라랜드.avi";
		
		try 
		{
			service.makeDirAndFiles(dir, info);
			System.out.println("디렉토리와 파일 4개 생성 완료");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
