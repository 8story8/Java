package step3;

// instanceof 연산자는 객체의 타입을 비교하는 연산자
// is a 관계일때 true 반환

public class TestInstanceof {

	public static void main(String[] args) {
		Animal a1 = new Person();
		Animal a2 = new Dog();
		System.out.println(a1 instanceof Person);	// true
		System.out.println(a1 instanceof Animal);	// true
		System.out.println(a2 instanceof Person);	// false
		System.out.println(a2 instanceof Dog);		// true
		System.out.println(a2 instanceof Animal);	// true
		System.out.println(a2 instanceof Object);	// true 
	}
}
