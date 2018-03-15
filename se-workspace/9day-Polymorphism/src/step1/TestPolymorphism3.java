package step1;

class Animal
{
	public void eat()
	{
		System.out.println("먹다.");
	}
	
	public void sleep()
	{
		System.out.println("자다.");
	}
}

class Person extends Animal
{
	public void eat()   // Method Overriding
	{
		System.out.println("수저로 먹다.");
	}
	
	public void study()   // 자식의 독자적인 멤버(메서드)
	{
		System.out.println("사람이 공부하다.");
	}
}

public class TestPolymorphism3 {

	public static void main(String[] args) {
		// 부모 타입의 변수에 자식 객체를 참조
		Animal a = new Person();
		
		a.sleep();   // 상속받은 메서드이므로 호출 가능
		a.eat();   // Overriding한 메서드이므로 호출 가능
		// a.study();   // a가 Person 객체지만 Animal 타입이므로 호출 불가, Compile Error
		// 아래와 같이 Object Down Casting이 필요
		((Person) a).study();
	}
}
