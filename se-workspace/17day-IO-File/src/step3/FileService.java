package step3;

import java.io.File;

public class FileService 
{
	public void printFilePath(String filePath) 
	{
		File f = new File(filePath);
		File fp = f.getParentFile();
		File fa[] = fp.listFiles();
		
		for(int i = 0; i < fa.length; i++)
		{
			if(fa[i].isFile() && filePath.equals(fa[i].getPath()) == false)
			{
				System.out.println(fa[i].getName());
			}
		}
	}
}
