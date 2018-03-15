package step4;

/*
채팅 클라이언트
나의 메세지를 서버로 출력(출력 Thread)
친구들의 메세지를 입력(입력 Thread)
*/

class InputWorker implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("입력 Thread 실행 " + i);
		}
	}
}

class OutputWorker implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("출력 Thread 실행 " + i);
		}
	}
}

public class TestThread4 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// InputWorker Thread와 OutputWorker Thread 생성 후 start()
		Thread t1 = new Thread(new InputWorker());
		Thread t2 = new Thread(new OutputWorker());
		
		t1.start();
		t2.start();
	}
}
