package step3;

// instanceof �����ڴ� ��ü�� Ÿ���� ���ϴ� ������
// is a �����϶� true ��ȯ

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
