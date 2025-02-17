package step2;

import java.io.File;
import java.io.IOException;

public class TestFile1 
{
	public static void main(String[] args) 
	{
		// File dir = new File("C:\\java-kosta");
		// OS마다 구분자가 다를 수 있으므로 아래와 같이 표현하는 것이 바람직하다.
		File dir = new File("C:" + File.separator +"java-kosta");
		System.out.println(dir.exists());			// 존재하면 true
		System.out.println(dir.isDirectory());	// 디렉토리면 true
		System.out.println(dir.isFile());			// 파일이면 true
		System.out.println(dir.getPath());		// 경로 반환
		
		// java-kosta 아래에 test 이름의 디렉토리를 생성
		File testDir = new File(dir.getPath() + File.separator + "test");
		System.out.println(testDir.mkdirs());
		
		// test 디렉토리에 a.txt 파일을 생성
		File file = new File(testDir.getPath() + File.separator + "a.txt");
		System.out.println(file.getPath());
		System.out.println(file.exists());
		
		// createNewFile() 메서드로 파일을 생성
		try 
		{
			boolean flag = file.createNewFile();
			System.out.println("파일 생성 " + flag);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println(file.exists());
		
		// 대상의 상위 디렉토리 정보를 문자열로 반환
		// a.txt 파일의 상위 디렉토리 경로는?
		System.out.println(file.getParent());
		
		// 대상의 상위 디렉토리 정보를 File 객체로 반환
		System.out.println(file.getParentFile());
		
		// a.txt와 동일한 위치에 b.txt를 생성
		File file2 = new File(file.getParentFile().getPath() + File.separator + "b.txt");
		try 
		{
			file2.createNewFile();
			System.out.println("b.txt");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("********************");
		
	    // listDir 디렉토리에 존재하는 파일 목록을 출력
		File listDir = new File("C:" + File.separator + "java-kosta" + File.separator + "test");
		System.out.println(listDir.isDirectory());
		String list[] = listDir.list();
		for(int i = 0; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
		
		System.out.println("********************");
		
		// listDir 디렉토리에 존재하는 파일 목록을 파일 객체로 반환받아 출력
		File fa[] = listDir.listFiles();
		for(int i = 0; i < fa.length; i++)
		{
			System.out.println(fa[i].getPath());
		}
	}
}
