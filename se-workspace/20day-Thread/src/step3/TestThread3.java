package step3;

// implements Runnable

class Worker implements Runnable
{
	public void run()   // Worker Thread�� ���� ����
							// JVM�� ���� ����
	{
		for(int i = 0 ; i < 100; i++)
		{
			System.out.println("Worker Thread ���� " + i);
		}
	}
}

public class TestThread3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Worker worker = new Worker();
		Thread t = new Thread(worker); 
		t.start();
		Thread.sleep(1);   // Main Thread 0.001�� �ߴ� �� �簳
		System.out.println("main thread ����");
	}
}
