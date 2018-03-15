package step3;

class Person
{
	int money = 100;
	static int sMoney = 200;
	
	public void test1()   // Object의 Member 메서드
	{
		System.out.println(money);
		System.out.println(sMoney);
		test2();
		test3();
		test4();
	}
	
	public static void test2()
	{
		System.out.println(sMoney);
		/// System.out.println(money);   // 이용하기 위해서는 객체 생성이 필요하다. 
												  // test2는 static 메서드이므로 객체 생성없이 외부에서 클래스명으로 실행 가능하고,
		  										  // 접근하려고 하는 money는 Instance Variable이므로 반드시 객체 생성을 명시해야
												  // money가 메모리에 적재된다는 보장을 할 수 있기 때문이다.
		// test3();   							  // 같은 이유로 Error
		test4();
	}
	
	public void test3()
	{
		
	}
	
	public static void test4()
	{
		
	}
}

public class TestStatic2 
{
	public static void main(String[] args) 
	{


	}
}
