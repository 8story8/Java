package step5;

import java.io.Serializable;

public class MemberVO implements Serializable
{
	private static final long serialVersionUID = 8394647400624741078L;
	
	private String id;
	private transient String password;
	private String name;
	private String address;
	
	public MemberVO(String id, String password, String name, String address) 
	{
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword() 
	{
		return password;
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
}
