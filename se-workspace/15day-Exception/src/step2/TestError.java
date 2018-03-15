package step2;

class ErrorEx
{
	public void a()
	{
		System.out.println("a Method 실행");
		b();
	}
	
	public void b()
	{
		System.out.println("b Method 실행");
		a();
	}
}

public class TestError 
{
	public static void main(String[] args) 
	{
		ErrorEx e = new ErrorEx();
		e.a();
		// 위 Method를 호출하면 Error 발생
		// 이 경우 프로그램을 수정하거나 환경을 변경해야 한다.
	}
}
