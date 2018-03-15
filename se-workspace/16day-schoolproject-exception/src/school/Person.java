package school;

import java.io.Serializable;

public abstract class Person
{
	private String tel;
	private String name;
	private String address;
	
	public Person(String tel, String name, String address) 
	{
		super();
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

	@Override
	public String toString() 
	{
		return ", address = " + address + ", name = " + name + ", tel = " + tel;
	}
}