package school;

public class Student extends Person
{
	private String stuId;
	
	Student(String tel, String name, String address, String stuId)
	{
		super(tel, name, address);
		this.stuId = stuId;
	}
	
	public String getStuId() 
	{
		return stuId;
	}

	public void setStuId(String stuId) 
	{
		this.stuId = stuId;
	}
	
	public String toString()
	{
		return super.toString() + ", stuId = " + this.getStuId();
	}
}
