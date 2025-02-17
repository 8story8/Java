package school;

public abstract class Person 
{
	private String tel;
	private String name;
	private String address;
	
	Person(String tel, String name, String address) 
	{
		super();
		this.tel = tel;
		this.name = name;
		this.address = address;
	}
	
	public String getTel() 
	{
		return tel;
	}
	
	public void setTel(String tel) 
	{
		this.tel = tel;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String toString()
	{
		return "tel = " + this.getTel() + ", name = " + this.getName() + ", address = " + this.getAddress();
	}
}
