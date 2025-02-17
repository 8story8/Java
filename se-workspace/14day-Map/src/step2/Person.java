package step2;

public class Person 
{
	private String name;
	private int age;
	
	public Person(String name, int age) 
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	@Override
	public String toString() {
		return "name = " + name + ", age = " + age;
	}
}
