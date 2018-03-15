package step9;

public class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getDetails()
	{
		return "사원명 : " + name + "  월급 : " + salary;
	}
}
