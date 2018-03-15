package step6;

import java.io.File;

public class MoveService 
{

	public void excute(String orgDir, String destDir, String ext) 
	{
		// 이동할 디렉토리를 생성
		new File(destDir).mkdirs();
		
		// 디렉토리 객체로부터 파일 객체 배열을 반환
		File orgFile[] = new File(orgDir).listFiles();
		
		for(int i = 0; i < orgFile.length; i++)
		{
			if(orgFile[i].isFile() && orgFile[i].getName().endsWith(ext))   // 파일이고 ext로 끝나면
			{
				orgFile[i].renameTo(new File(destDir + File.separator + orgFile[i].getName()));   // destDir로 이동
			}
		}
	}
}

