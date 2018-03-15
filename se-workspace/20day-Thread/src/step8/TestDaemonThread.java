package step8;

class BackUpWorker extends Thread
{
	public void run()
	{
		while(true)
		{
			System.out.println("BackUp Task");
			
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException ie) 
			{
				ie.printStackTrace();
			}
			
			System.out.println("BackUp Task Complete");
		}
		
		
	}
}

class NotePad extends Thread
{
	public void run()
	{
		/*
		Word Task 시작시 BackUp Thread를 start()시킨다.
		실행하면 Word Task Complete후에도,
		계속 Backup Thread는 실행이 지속된다.
		Word Task Complete되면 BackUp Thread도 같이 종료되도록,
		Thread의 setDaemon(true)를 설정한다.
		*/
		
		BackUpWorker backup = new BackUpWorker();
		// 자신을 start()시킨 Thread(NotePad)가 종료되면 함께 종료되도록 설정
		backup.setDaemon(true);
		backup.start();
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Word Task " + i);
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		
		System.out.println("Word Task Complete");
	}
}

public class TestDaemonThread 
{
	public static void main(String[] args) 
	{
		new NotePad().start();
	}
}
