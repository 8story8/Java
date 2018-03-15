package step8;

class Animal
{
	public void eat()
	{
		System.out.println("�Դ�.");
	}
}

class Person extends Animal
{
	// Method Overriding : �θ� �޼��带 �ڽſ� �°� ������
	public void eat()
	{
		System.out.println("������ �Դ�.");
	}
}

class Dog extends Animal
{
}

class Student extends Person
{
	public void eat()
	{
		super.eat();   // super Keyword�� �̿��� �θ� �޼��� ȣ��
		System.out.println("����Ʈ�� �Դ�");
	}
}

public class TestOverriding1 {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();   // ��ӹ��� �θ� eat ����
		
		Person p = new Person();
		p.eat();   // Overriding�� �ڽ��� eat ����
		
		Student stu = new Student();
		stu.eat();
	}
}
