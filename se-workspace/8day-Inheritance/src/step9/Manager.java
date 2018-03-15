package step9;

public class Manager extends Employee{
	private String department;
	
	public Manager(String name, int salary, String department) 
	{
		super(name, salary);
		this.department = department;
	}
	
	public String getDetails()   // Method Overriding
	{
		// super를 이용해 부모 메서드를 재사용
		return super.getDetails() + "  부서명 : " + department;
	}
}
