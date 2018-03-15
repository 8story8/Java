package step2;

class Person
{
	int age = 1;
	static int sAge = 1;
	public static void test()
	{
		System.out.println("static test 실행" + sAge);
	}
}

public class TestStatic1 {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.age);
		
		// 객체 생성없이 클래스명.static 변수로 사용 가능
		System.out.println(Person.sAge);
		
		// static 메서드이므로 객체 생성없이 클래스명으로 호출
		Person.test();
	}
}
