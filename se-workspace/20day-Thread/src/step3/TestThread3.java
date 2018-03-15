package step3;

// implements Runnable

class Worker implements Runnable
{
	public void run()   // Worker Thread의 실행 내용
							// JVM에 의해 실행
	{
		for(int i = 0 ; i < 100; i++)
		{
			System.out.println("Worker Thread 실행 " + i);
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
		Thread.sleep(1);   // Main Thread 0.001초 중단 후 재개
		System.out.println("main thread 종료");
	}
}
