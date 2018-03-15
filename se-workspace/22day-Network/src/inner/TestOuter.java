package inner;

/*
Inner 클래스(or Nested 클래스)를 사용하는 이유는
Outer 클래스의 private 멤버에 직접 접근해 사용하기 위해서이다.
(private 멤버는 다른 클래스에서는 접근 불가하지만 Inner 클래스는 예외로 한다.)
ref) Inner 클래스 컴파일 후 클래스 형태 : Outer$Inner.class
*/

class Outer
{
	private String password;   // private으로 선언했으므로 다른 클래스에서는 접근 불가
	
	Outer(String password)
	{
		this.password = password;
	}
	
	class Inner
	{
		public void test()
		{
			// Outer 클래스의 private 멤버에 직접 접근해 사용 가능
			System.out.println(password);
		}
	}
}

public class TestOuter
{
	public static void main(String[] args) 
	{
		Outer outer = new Outer("javaking");
		// Inner 클래스(or Nested 클래스) 객체 생성을 위해서는,
		// Outer 클래스 객체 생성이 전제되어야 한다.
		Outer.Inner inner = outer.new Inner();
		inner.test();
	}
}
