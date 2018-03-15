package step11;

class Animal
{
	public void eat()
	{
		System.out.println("먹다.");
	}
}

class Person extends Animal
{
	public void eat()   // Method Overriding
	{
		System.out.println("수저로 먹다.");
	}
}

class Dog extends Animal
{
	
}

class Cat extends Animal
{
	
}

class Truck
{
	
}

class Service
{
	/*
	Animal 타입의 a 참조 변수(매개 변수)는 
	Animal 및 다양한 Animal 하위(자식) 객체 참조 가능
	 */
	
	public void receive(Animal a)
	{
		// eat() 메시지 방식 하나만 이해하면 다양한 객체의 eat 실행 가능
		a.eat();
	}
}

public class TestPolymorphism2 {
	public static void main(String[] args) {
		Service service = new Service();
		
		service.receive(new Animal());
		service.receive(new Person());
		service.receive(new Dog());
		service.receive(new Cat());
		
		// 아래는 상속 계층 구조에 있지 않으므로
		// 즉, 자식이 아니므로 Compile Error
		// service.receive(new Car());
	}
}
