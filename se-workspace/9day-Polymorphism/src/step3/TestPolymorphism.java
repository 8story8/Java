package step3;

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
		System.out.println("사람이 수저로 먹다.");
	}
	
	public void study()
	{
		System.out.println("사람이 공부하다.");
	}
}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("개가 사료를 먹다.");
	}
}

class AnimalService
{
	public void execute(Animal a)
	{
		a.eat();
		a.sleep();
		if(a instanceof Person)   // a가 Person 객체 타입이면
		{
			((Person) a).study();  // Object Down Casting
		}
	}
}

public class TestPolymorphism {

	public static void main(String[] args) {
		AnimalService service = new AnimalService();
	
		service.execute(new Dog()); 
		service.execute(new Person());
		// 개가 사료를 먹다
		// 자다
		// 사람이 수저로 먹다
		// 자다
		// 사람이 공부하다
	}

}
