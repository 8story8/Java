package step2;

class Employee   // extends Object
{
	public void calSalary()
	{
		System.out.println("�Ϲ� ��� ���� ���");
	}
}

class Manager extends Employee
{
	public void calSalary()
	{
		System.out.println("�Ŵ��� ���� ���");
	}
}

class Engineer extends Employee
{
	public void calSalary()
	{
		System.out.println("�����Ͼ� ���� ���");
	}
}

class HRService
{
	// ���� �θ� Ÿ���� ������ �پ��� ��ü�� ó��
	public void process(Employee e)
	{
		// Overriding�� Method�� ȣ���ϸ� �پ��� ��ü���� ������ ������� ����
		e.calSalary();
	}
}

public class TestPolymorphism4 {

	public static void main(String[] args) {
		HRService service = new HRService();
		service.process(new Manager());
		service.process(new Engineer());
		service.process(new Employee());
	}
}
