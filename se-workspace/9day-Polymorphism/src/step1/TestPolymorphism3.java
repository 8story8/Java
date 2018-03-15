package step1;

class Animal
{
	public void eat()
	{
		System.out.println("�Դ�.");
	}
	
	public void sleep()
	{
		System.out.println("�ڴ�.");
	}
}

class Person extends Animal
{
	public void eat()   // Method Overriding
	{
		System.out.println("������ �Դ�.");
	}
	
	public void study()   // �ڽ��� �������� ���(�޼���)
	{
		System.out.println("����� �����ϴ�.");
	}
}

public class TestPolymorphism3 {

	public static void main(String[] args) {
		// �θ� Ÿ���� ������ �ڽ� ��ü�� ����
		Animal a = new Person();
		
		a.sleep();   // ��ӹ��� �޼����̹Ƿ� ȣ�� ����
		a.eat();   // Overriding�� �޼����̹Ƿ� ȣ�� ����
		// a.study();   // a�� Person ��ü���� Animal Ÿ���̹Ƿ� ȣ�� �Ұ�, Compile Error
		// �Ʒ��� ���� Object Down Casting�� �ʿ�
		((Person) a).study();
	}
}
