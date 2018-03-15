package step1.review;   // Package : 디렉토리별로 Class 분류, 소문자 시작

// Class 선언 : Object 생성을 위한 틀, 대문자 시작
public class Employee {
	 /*
	 private으로 외부(다른 Class or 다른 Package)의 접근 차단
	 Variable or Instance Variable or Member Variable
	 Object 속성 정보 저장
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
