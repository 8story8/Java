package step8;

class Animal
{
	public void eat()
	{
		System.out.println("먹다.");
	}
}

class Person extends Animal
{
	// Method Overriding : 부모 메서드를 자신에 맞게 재정의
	public void eat()
	{
		System.out.println("수저로 먹다.");
	}
}

class Dog extends Animal
{
}

class Student extends Person
{
	public void eat()
	{
		super.eat();   // super Keyword를 이용해 부모 메서드 호출
		System.out.println("디저트를 먹다");
	}
}

public class TestOverriding1 {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();   // 상속받은 부모 eat 실행
		
		Person p = new Person();
		p.eat();   // Overriding한 자신의 eat 실행
		
		Student stu = new Student();
		stu.eat();
	}
}
