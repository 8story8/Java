package step9;

/*
단일 Thread 환경에서 테스트
(순차적으로 실행하므로 문제 없다.)
*/

class Toilet
{
	private boolean seat;   // Default Initialization false
	
	public void use(String user) throws InterruptedException
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
}

public class TestSynchronized1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Toilet t = new Toilet();
			
			t.use("뽀로로");
			t.use("크로커다일");
		} 
		catch (InterruptedException ie) 
		{
			ie.printStackTrace();
		}
	}
}
