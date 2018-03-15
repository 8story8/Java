package step4;

/*
ä�� Ŭ���̾�Ʈ
���� �޼����� ������ ���(��� Thread)
ģ������ �޼����� �Է�(�Է� Thread)
*/

class InputWorker implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("�Է� Thread ���� " + i);
		}
	}
}

class OutputWorker implements Runnable
{
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("��� Thread ���� " + i);
		}
	}
}

public class TestThread4 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// InputWorker Thread�� OutputWorker Thread ���� �� start()
		Thread t1 = new Thread(new InputWorker());
		Thread t2 = new Thread(new OutputWorker());
		
		t1.start();
		t2.start();
	}
}
