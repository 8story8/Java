package step11;

/*
step9�� ���� Thread ȯ�濡�� �׽�Ʈ
(���������� �����ϹǷ� ���� ����.)

step10�� ���� Thread ȯ�濡�� �׽�Ʈ
���� �ڿ�(Toilet ��ü�� Data(Instance Variable : seat))��
���� Thread�� ���ÿ� ����Ͽ� �߻��� �� �ִ� ������ �����ش�.

step11�� ���� Thread ȯ�濡�� �׽�Ʈ
���� �ڿ��� �����ϴ� Method(or Code Area)��
���� Thread ȯ������ ����� synchronized(����ȭ ó��)�� �Ѵ�.
*/

class Toilet implements Runnable
{
	private boolean seat;   // Default Initialization false
	
	public synchronized void use(String user) throws InterruptedException
	{
		if(seat == false)
		{
			Thread.sleep(1000);
			System.out.println(user + " ����");
			Thread.sleep(1000);
			seat = true;
			System.out.println(user + " ���");
			Thread.sleep(2000);
			seat = false;
			System.out.println(user + " ����");
		}
		else
		{
			System.out.println(user + "�� ���� ȭ��� ��� ���̹Ƿ� ��� �Ұ�!");
		}
	}
	@Override
	public void run() 
	{
		try 
		{
			use(Thread.currentThread().getName());
		} 
		catch (InterruptedException ie) 
		{
			ie.printStackTrace();
		}
	}
}

public class TestSynchronized3
{
	public static void main(String[] args) throws InterruptedException 
	{
		Toilet t = new Toilet();   // ���� ��ü
		
		Thread userThread1 = new Thread(t, "�Ƿη�");
		Thread userThread2 = new Thread(t, "ũ��Ŀ����");
		Thread userThread3 = new Thread(t, "���Ű ���̼�");
		
		userThread1.start();
		userThread2.start();
		userThread3.start();
	}
}
