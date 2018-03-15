package step6;

abstract class Parent
{
	public void eat()
	{
		System.out.println("�Դ�.");
	}
	
	// abstract �޼��� : �����ξ��� ���� �Ѵ�.
	// �ڽ� Ŭ�������� ������ �����Ѵ�.
	// abstract �޼��尡 �ϳ� �̻� �����ϸ� �� Ŭ������ abstract Ŭ������ ����Ǿ� �Ѵ�.
	// abstract Ŭ������ ���� ��üȭ �� �� ����.
	public abstract void study();
}

class Child extends Parent
{
	// �θ� Ŭ������ abstract �޼��带 �ݵ�� �����ؾ�, 
	// ��ü ���� ������ �ڽ� Ŭ������ �� �� �ִ�.
	public void study() {
		System.out.println("�����ϴ�.");	
	}
}

public class TestAbstract1 {
	public static void main(String[] args) {
		// Error : Abstract Ŭ�����̹Ƿ� ���� ��üȭ�� �� ����.
		// new Parent();
		Child c = new Child();
		c.eat();
		c.study();
	}
}
