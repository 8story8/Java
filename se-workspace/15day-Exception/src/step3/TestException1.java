package step3;

/*
Exception은 프로그램이 실행하다가 발생할 수 있는 예외
JVM은 이러한 예외 상황을 만나면 해당 Exception 객체를 발생시키고,
즉시 비정상 종료된다.
*/

public class TestException1 
{
	public static void main(String[] args) 
	{
		String name = "설현";
		System.out.println(name.length());
		System.out.println("프로그램이 정상 수행 후 종료");
	}
}
