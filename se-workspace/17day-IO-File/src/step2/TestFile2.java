package step2;

import java.io.File;

public class TestFile2 
{
	public static void main(String[] args) 
	{
		String dir = "C:\\java-kosta\\util\\eclipse-jee-neon-2-win32-x86_64\\eclipse";
		File listDir = new File(dir);
		File fa[] = listDir.listFiles();
		
		for(int i = 0; i < fa.length; i++)
		{
			if(fa[i].isFile())
			{
				System.out.println(fa[i].getName());
			}
		}
	}
}
