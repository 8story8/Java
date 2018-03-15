package step11;

/*
step9는 단일 Thread 환경에서 테스트
(순차적으로 실행하므로 문제 없다.)

step10은 다중 Thread 환경에서 테스트
공유 자원(Toilet 객체의 Data(Instance Variable : seat))을
여러 Thread가 동시에 사용하여 발생할 수 있는 문제를 보여준다.

step11도 다중 Thread 환경에서 테스트
공유 자원에 접근하는 Method(or Code Area)에
단일 Thread 환경으로 만드는 synchronized(동기화 처리)를 한다.
*/

class Toilet implements Runnable
{
	private boolean seat;   // Default Initialization false
	
	public synchronized void use(String user) throws InterruptedException
	{
		if(seat == false)
		{
			Thread.sleep(1000);
			System.out.println(user + " 입장");
			Thread.sleep(1000);
			seat = true;
			System.out.println(user + " 사용");
			Thread.sleep(2000);
			seat = false;
			System.out.println(user + " 퇴장");
		}
		else
		{
			System.out.println(user + "가 현재 화장실 사용 중이므로 사용 불가!");
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
		Toilet t = new Toilet();   // 공유 객체
		
		Thread userThread1 = new Thread(t, "뽀로로");
		Thread userThread2 = new Thread(t, "크로커다일");
		Thread userThread3 = new Thread(t, "사사키 하이세");
		
		userThread1.start();
		userThread2.start();
		userThread3.start();
	}
}
