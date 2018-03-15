package step1.review;   // Package : ���丮���� Class �з�, �ҹ��� ����

// Class ���� : Object ������ ���� Ʋ, �빮�� ����
public class Employee {
	 /*
	 private���� �ܺ�(�ٸ� Class or �ٸ� Package)�� ���� ����
	 Variable or Instance Variable or Member Variable
	 Object �Ӽ� ���� ����
	 */
	private String name;
	private int age; // Member Variable or Instance Variable
	
	// Method
	public void setName(String n){   // n : Parameter or Local Variable
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age){   // n : Parameter or Local Variable
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
}
