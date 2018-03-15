package step3;

import java.io.Serializable;

/*
Person Ŭ������ ������ ��ü�� ����ȭ�Ǿ� �ܺο� ����(���)�Ǳ� ���ؼ���
�ݵ�� Serializable �������̽��� implements�ؾ� �Ѵ�.
*/

public class Person implements Serializable
{
	private static final long serialVersionUID = 1176114819554034463L;
	// ���� Ŭ������ ��� ���� �Ǵ� �޼��� ������ ����Ǵ���,
	// ������ȭ�� �����ϵ��� ��������� serialVersionUID���� �Ҵ��Ѵ�.
	
	private String name;
	private String address;
	private transient String password;   // transient : ����ȭ ��󿡼� ���ܽ�Ų��.
	
	public Person(String name, String address, String password) 
	{
		super();
		this.name = name;
		this.address = address;
		this.password = password;
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
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void test()
	{
	}
}
