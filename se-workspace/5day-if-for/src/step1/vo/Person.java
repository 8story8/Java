package step1.vo;

public class Person {
	private String name;   // Instance Variable
	private int age;   // Instance Variable

	// Constructor
	public Person(String name, int age) {   // Local Variable or Parameter
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {   // method setter 정보 할당
		this.name = name;
	}

	public String getName() {   // method getter 정보 반환
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

}
