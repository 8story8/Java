package step3;

import java.io.Serializable;

/*
Person 클래스로 생성된 객체가 직렬화되어 외부에 전송(출력)되기 위해서는
반드시 Serializable 인터페이스를 implements해야 한다.
*/

public class Person implements Serializable
{
	private static final long serialVersionUID = 1176114819554034463L;
	// 이후 클래스의 멤버 변수 또는 메서드 정보가 변경되더라도,
	// 역직렬화가 가능하도록 명시적으로 serialVersionUID값을 할당한다.
	
	private String name;
	private String address;
	private transient String password;   // transient : 직렬화 대상에서 제외시킨다.
	
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
