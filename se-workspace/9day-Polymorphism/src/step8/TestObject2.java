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
	
	// Object Ŭ������ toString �޼��带 Overriding
	public String toString() {
		return "ȸ��� : " + name + "     �ּ� : " + address;
	}
}

public class TestObject2 {
	/*
 	java.lang.Object �ֻ��� Ŭ������ toString() �޼��带 
	Overriding�Ͽ� ��ü�� �ּҰ� ��� ��ü�� �Ӽ� ������ ��ȯ�ϵ��� ó��
	*/
	public static void main(String[] args) 
	{
		Company c1 = new Company("�̸�", "����");
		Company c2 = new Company("K", "����");
		System.out.println(c1.toString());	// �ּҰ� ���
		System.out.println(c1);				
		System.out.println(c2);				// ���� �����ϰ� ��ü�� �ּҰ� ���
		System.out.println(c2.toString());	
		System.out.println("********************");
		Company2 com = new Company2("Google", "Silicon Valley");
		System.out.println(com.toString());
		System.out.println(com);
		System.out.println("********************");
		Object objCom[] = {new Company2("Apple", "����"), new Company2("NC", "�Ǳ�"), new Company2("Daum Kakao", "����")};
		/*
		for���� �̿��� ������ ���� ����Ѵ�.
		ȸ��� : Apple   �ּ� : ����
		ȸ��� : NC   �ּ� : �Ǳ�
		ȸ��� : Daum Kakao   �ּ� : ����
		*/
		for(int i = 0; i < objCom.length; i++)
		{
			System.out.println(objCom[i]);
		}
	}
}
