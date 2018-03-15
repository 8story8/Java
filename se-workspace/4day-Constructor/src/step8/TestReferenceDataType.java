package step8;

public class TestReferenceDataType {

	public static void main(String[] args) {
	/*
	SmartPhone : Reference Data Type
	sp1 : Reference Variable
	= : Assign
	new : Java Keyword
	SmartPhone() : Constructor
	*/
	SmartPhone sp1 = new SmartPhone("iPhone 7");
    // System.out.println(sp1);   // 객체 주소값 출력

	SmartPhone sp2 = new SmartPhone("Galaxy S7");
	// System.out.println(sp2);   // 객체 주소값 출력
	
	// sp1 주소값을 sp2에 할당
	sp2 = sp1;
	System.out.println(sp1.getModel());
	System.out.println(sp2.getModel());
	}
}
