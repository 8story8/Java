package step5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService 
{
	/*
	public void copyAndPasteDir(String orgDir, String destDir) throws IOException 
	{
		new File(destDir).mkdirs();
		
		File orgDirList[] =  new File(orgDir).listFiles();
		
		for(int i = 0; i < orgDirList.length; i++)
		{
			BufferedReader br = new BufferedReader(new FileReader(orgDirList[i].getPath()));
			PrintWriter pw = new PrintWriter(new FileWriter(destDir + File.separator + orgDirList[i].getName(), true));
			
			String data = br.readLine();
			
			while(data != null)
			{
				pw.println(data);
				data = br.readLine();
			}
			
			br.close();
			pw.close();
		}
	}
	*/
	
	public void copyAndPasteDir(String orgDir, String destDir) throws IOException
	{
		new File(destDir).mkdirs();
		
		File list[] = new File(orgDir).listFiles();
		
		for(int i = 0; i < list.length; i++)
		{
			copyAndPasteFile(list[i].getPath(), destDir + File.separator + list[i].getName());
		}
	}
	
	public void copyAndPasteFile(String orgPath, String destPath) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(orgPath));
		PrintWriter pw = new PrintWriter(new FileWriter(destPath));
		
		String line = br.readLine();
		
		while(line != null)
		{
			pw.println(line);
			line = br.readLine();
		}
		
		br.close();
		pw.close();
	}
}
