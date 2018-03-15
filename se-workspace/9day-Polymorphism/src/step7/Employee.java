package step7;

public class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) 
	{
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
	
	public int getSalary() 
	{
		return salary;
	}
}
