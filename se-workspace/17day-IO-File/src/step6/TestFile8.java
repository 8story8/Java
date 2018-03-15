package step6;

public class TestFile8 
{
	public static void main(String[] args) 
	{
		MoveService service = new MoveService();
		String orgDir = "C:\\java-kosta\\test\\media2";
		String destDir = "C:\\java-kosta\\test\\music";
		String ext = "mp3";
		
		service.excute(orgDir, destDir, ext);
		System.out.println("이동 완료");
	}
}
