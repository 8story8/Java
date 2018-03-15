package step2;

/*
Multi-Thread를 정의해서 실행해본다.
Main Thread + Worker Thread 동시에 두 가지 Thread를 실행시켜 본 결과를 확인한다.
(step1 예제와 어떤 차이점이 있는지 분석)
*/

class Worker extends Thread
{
	// run()을 Overriding하여 Worker Thread의 작업 내용을 정의한다.
	@Override
	public void run() 
	{
		for(int i = 0; i < 100 ; i++)
		{
				System.out.println("직원(Thread) 일을 하다 " + i);
		}
	}
}

public class TestThread2 
{
	public static void main(String[] args) 
	{
		Worker wt = new Worker();
		wt.start();   // Thread를 실행 가능 상태로 보낸다.
					   // JVM이 Scheduling을 하면 실행된다.
					   // 즉, JVM에 의해 run()이 호출된다는 것을 의미한다.
		System.out.println("Main Thread 종료");
	}
}
