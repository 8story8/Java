package step1;

//interface�� �����Ͽ� ���� ������ �����ϰ� �Ѵ�.
interface Flyer
{ 
	String ID = "javaking";   // public static final�� �ڵ� ����
	public static void test()   // jdk 1.8���� ����
	{
		System.out.println("interface�� static Method�� ������ �� �ִ�.");
	}
	// public void fly(){ }   // Compile Error : ��ü�� ������ �޼��带 ������ �� ����.
	public void fly();   // abstract�� �ڵ� ����
}

class Animal
{
	
}

class Bird extends Animal implements Flyer
{
	@Override
	public void fly() 
	{
		System.out.println("���� ����.");
	}
}

class Airplane implements Flyer
{
	@Override
	public void fly() 
	{
		System.out.println("����Ⱑ ����.");
	}
}

public class TestInterface1 
{
	public static void main(String[] args) 
	{
		// ���� �������̽� Ÿ���� ������ ���� ��ü ���� ����
		// ��, �������� �����ȴ�.
		Flyer f1 = new Bird();
		f1.fly();
		Flyer f2 = new Airplane();
		f2.fly();
		
		// Flyer f3 = new Animal();   // Animal�� Flyer�� implements���� �ʾұ� ������ Error
		// f2.ID = "STAR";   // final ����̹Ƿ� ���Ҵ� �Ұ�
		
		System.out.println(Flyer.ID);
		Flyer.test();
		// �� �� ����ó�� interface�� �߻� �޼���(�߿�) ����ܿ�
		// static final ��� �� static Method(jdk 1.8 ~)�� ������ �� �ִ�.
	}
}
