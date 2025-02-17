package step2;

class Employee   // extends Object
{
	public void calSalary()
	{
		System.out.println("일반 사원 월급 계산");
	}
}

class Manager extends Employee
{
	public void calSalary()
	{
		System.out.println("매니저 월급 계산");
	}
}

class Engineer extends Employee
{
	public void calSalary()
	{
		System.out.println("엔지니어 월급 계산");
	}
}

class HRService
{
	// 공통 부모 타입의 변수로 다양한 객체를 처리
	public void process(Employee e)
	{
		// Overriding한 Method를 호출하면 다양한 객체들이 각자의 방식으로 동작
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
