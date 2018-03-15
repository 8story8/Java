package step2;

class Animal
{
	private int age = 1;

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}

class Person extends Animal   // 상속 관계를 표현
{
	public void study()
	{
		System.out.println("공부하다.");
	}
}

public class TestInheritance2 {
	public static void main(String[] args) {
		Person p = new Person();
		// System.out.println(p.age);
		// 위 코드는 age가 private이므로 상속받더라도 직접 접근은 불가능해서 Error
		// 아래처럼 getter/setter로 간접 접근
		System.out.println(p.getAge());
	
	}

}
