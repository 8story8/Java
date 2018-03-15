package step1;

class Worker
{
	public void work()
	{
		for(int i = 0; i < 100 ; i++)
		{
				System.out.println("직원이 일을 하다 " + i);
		}
	}
}

public class TestThread1
{
	public static void main(String[] args) 
	{
		Worker w = new Worker();
		w.work();
	}
}
