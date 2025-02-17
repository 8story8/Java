package school;

public class Teacher extends Person
{
	private String subject;

	public Teacher(String tel, String name, String address, String subject) 
	{
		super(tel, name, address);
		this.subject = subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	
	public String getSubject() 
	{
		return subject;
	}

	@Override
	public String toString() 
	{
		return "Teacher subject = " + subject + super.toString();
	}
}