package step3;

public class TestException5 
{
	// 실행 결과를 예측해보는 예제
	/*
	하나의 try 블럭에 catch문을 여러 개 정의할 수 있다.
	catch문 정의시 자식(객체) -> 부모(추상)순으로 정의해야 한다.
	*/
	public static void main(String[] args) 
	{
		// String str = null;
		String str = "";
		try
		{
		System.out.println(str.concat("A"));
		System.out.println("E");
		}
		catch(IndexOutOfBoundsException ie)
		{
			System.out.println("C");
		}
		catch(Exception e)
		{
			System.out.println("D");
		}
		System.out.println("B");
	}
}
