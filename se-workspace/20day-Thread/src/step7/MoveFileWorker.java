package step7;

import java.io.File;

public class MoveFileWorker implements Runnable
{
	private int second;
	private int fileCount;

	public MoveFileWorker(int second, int fileCount) 
	{
		super();
		this.second = second;
		this.fileCount = fileCount;
		new File(CommonInfo.MUSIC_PATH).mkdirs();
		new File(CommonInfo.MOVIE_PATH).mkdirs();
	}

	public void run()
	{
		for(int i = 0; i < fileCount; i++)
		{
			try 
			{
				Thread.sleep(second);
				
				File moveFileList[] = new File(CommonInfo.MAKE_PATH).listFiles();
				
				for(int j = 0; j < moveFileList.length; j++)
				{
					if(moveFileList[j].getName().endsWith(".mp3"))
					{
						moveFileList[j].renameTo(new File(CommonInfo.MUSIC_PATH + File.separator + moveFileList[j].getName()));
					}
					
					if(moveFileList[j].getName().endsWith(".avi"))
					{
						moveFileList[j].renameTo(new File(CommonInfo.MOVIE_PATH + File.separator + moveFileList[j].getName()));
					}	
				}
			} 
			catch (InterruptedException ie) 
			{
				ie.printStackTrace();
			}
		}
	}
}
				
			
			
			
			
			
		
	

