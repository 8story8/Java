package step6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService 
{
	public void copyAndPasteDir(String orgDir, String destFile) throws IOException 
	{
		new File(destFile).getParentFile().mkdirs();
		
		File list[] = new File(orgDir).listFiles();
		
		PrintWriter pw = new PrintWriter(new FileWriter(destFile), true);
		
		for(int i = 0; i < list.length; i++)
		{
			BufferedReader br = new BufferedReader(new FileReader(list[i].getPath()));
			
			String line = br.readLine();
			
			while(line != null)
			{
				pw.println(line);
				line = br.readLine();
			}
			pw.println();
			
			br.close();
		}
		
		pw.close();
	}
}
