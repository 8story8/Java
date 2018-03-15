package step8;

class Company
{
	private String name;
	private String address;
	
	public Company(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}

class Company2
{
	private String name;
	private String address;
	
	public Company2(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
	// Object 클래스의 toString 메서드를 Overriding
	public String toString() {
		return "회사명 : " + name + "     주소 : " + address;
	}
}

public class TestObject2 {
	/*
 	java.lang.Object 최상위 클래스의 toString() 메서드를 
	Overriding하여 객체의 주소값 대신 객체의 속성 정보를 반환하도록 처리
	*/
	public static void main(String[] args) 
	{
		Company c1 = new Company("미르", "강남");
		Company c2 = new Company("K", "서초");
		System.out.println(c1.toString());	// 주소값 출력
		System.out.println(c1);				
		System.out.println(c2);				// 위와 동일하게 객체의 주소값 출력
		System.out.println(c2.toString());	
		System.out.println("********************");
		Company2 com = new Company2("Google", "Silicon Valley");
		System.out.println(com.toString());
		System.out.println(com);
		System.out.println("********************");
		Object objCom[] = {new Company2("Apple", "구미"), new Company2("NC", "판교"), new Company2("Daum Kakao", "제주")};
		/*
		for문을 이용해 다음과 같이 출력한다.
		회사명 : Apple   주소 : 구미
		회사명 : NC   주소 : 판교
		회사명 : Daum Kakao   주소 : 제주
		*/
		for(int i = 0; i < objCom.length; i++)
		{
			System.out.println(objCom[i]);
		}
	}
}
