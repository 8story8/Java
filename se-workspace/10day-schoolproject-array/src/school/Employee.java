package school;

public class Employee extends Person
{
	private String dept;

	Employee(String tel, String name, String address, String dept)
	{
		super(tel, name, address);
		this.dept = dept;
	}
	
	public void setDept(String dept) 
	{
		this.dept = dept;
	}
	
	public String getDept() 
	{
		return dept;
	}	
	
	public String toString()
	{
		return super.toString() + ", dept : " + this.dept;
	}
}
