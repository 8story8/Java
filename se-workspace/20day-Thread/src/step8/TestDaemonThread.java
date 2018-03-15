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
		Word Task ���۽� BackUp Thread�� start()��Ų��.
		�����ϸ� Word Task Complete�Ŀ���,
		��� Backup Thread�� ������ ���ӵȴ�.
		Word Task Complete�Ǹ� BackUp Thread�� ���� ����ǵ���,
		Thread�� setDaemon(true)�� �����Ѵ�.
		*/
		
		BackUpWorker backup = new BackUpWorker();
		// �ڽ��� start()��Ų Thread(NotePad)�� ����Ǹ� �Բ� ����ǵ��� ����
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
