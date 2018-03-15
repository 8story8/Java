package step1;

//interface를 정의하여 계층 구조를 형성하게 한다.
interface Flyer
{ 
	String ID = "javaking";   // public static final이 자동 삽입
	public static void test()   // jdk 1.8부터 가능
	{
		System.out.println("interface는 static Method를 정의할 수 있다.");
	}
	// public void fly(){ }   // Compile Error : 객체의 구현된 메서드를 정의할 수 없다.
	public void fly();   // abstract가 자동 삽입
}

class Animal
{
	
}

class Bird extends Animal implements Flyer
{
	@Override
	public void fly() 
	{
		System.out.println("새가 날다.");
	}
}

class Airplane implements Flyer
{
	@Override
	public void fly() 
	{
		System.out.println("비행기가 날다.");
	}
}

public class TestInterface1 
{
	public static void main(String[] args) 
	{
		// 상위 인터페이스 타입의 변수로 하위 객체 참조 가능
		// 즉, 다형성이 지원된다.
		Flyer f1 = new Bird();
		f1.fly();
		Flyer f2 = new Airplane();
		f2.fly();
		
		// Flyer f3 = new Animal();   // Animal은 Flyer를 implements하지 않았기 때문에 Error
		// f2.ID = "STAR";   // final 상수이므로 재할당 불가
		
		System.out.println(Flyer.ID);
		Flyer.test();
		// 위 두 라인처럼 interface는 추상 메서드(중요) 선언외에
		// static final 상수 및 static Method(jdk 1.8 ~)를 정의할 수 있다.
	}
}
