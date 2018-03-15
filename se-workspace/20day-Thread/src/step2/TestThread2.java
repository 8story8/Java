package step2;

/*
Multi-Thread�� �����ؼ� �����غ���.
Main Thread + Worker Thread ���ÿ� �� ���� Thread�� ������� �� ����� Ȯ���Ѵ�.
(step1 ������ � �������� �ִ��� �м�)
*/

class Worker extends Thread
{
	// run()�� Overriding�Ͽ� Worker Thread�� �۾� ������ �����Ѵ�.
	@Override
	public void run() 
	{
		for(int i = 0; i < 100 ; i++)
		{
				System.out.println("����(Thread) ���� �ϴ� " + i);
		}
	}
}

public class TestThread2 
{
	public static void main(String[] args) 
	{
		Worker wt = new Worker();
		wt.start();   // Thread�� ���� ���� ���·� ������.
					   // JVM�� Scheduling�� �ϸ� ����ȴ�.
					   // ��, JVM�� ���� run()�� ȣ��ȴٴ� ���� �ǹ��Ѵ�.
		System.out.println("Main Thread ����");
	}
}
