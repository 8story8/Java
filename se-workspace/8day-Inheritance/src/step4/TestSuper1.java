package step4;

class A // extends Object
{
	A()
	{
		// super();
		System.out.println("A 객체 생성");
	}
}

class B extends A
{
	B()
	{
		// super();
		System.out.println("B 객체 생성");
	}
}

class C extends B
{
	C()
	{
		// super();
		System.out.println("C 객체 생성");
	}
}

public class TestSuper1 {
	public static void main(String[] args) {
		new C();
		// A -> B -> C 순서로 객체 생성
		// Constructor에 super()가 명시되어 있지 않으면
		// Complile시 삽입
	}
}
