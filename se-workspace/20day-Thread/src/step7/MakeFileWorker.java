package step7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class MakeFileWorker implements Runnable
{
	private int second;
	private int fileCount;
	
	public MakeFileWorker(int second, int fileCount) 
	{
		super();
		this.second = second;
		this.fileCount = fileCount;
		new File(CommonInfo.MAKE_PATH).mkdirs();
	}

	public void run()
	{
		Random r = new Random();
		
		String ext[] = {".mp3", ".avi"};
		
		for(int i = 0; i < fileCount; i++)
		{
			try 
			{
				Thread.sleep(second);
				
				PrintWriter file = new PrintWriter(new File(CommonInfo.MAKE_PATH + File.separator + i + ext[r.nextInt(ext.length)]));
				file.close();
			} 
			catch (FileNotFoundException | InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

