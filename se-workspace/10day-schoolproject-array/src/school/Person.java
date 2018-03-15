package school;

public class Person 
{
	private String tel;
	private String name;
	private String address;
	
	Person(String tel, String name, String address)
	{
		this.tel = tel;
		this.name = name;
		this.address = address;
	}
	
	public void setTel(String tel) 
	{
		this.tel = tel;
	}
	
	public String getTel() 
	{
		return tel;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	public String getName() 
	{
		return name;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}

	public String toString()
	{
		return "tel = " + this.tel + ", name = " + this.name + ", address : " + this.address; 
	}
}
