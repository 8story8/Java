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
    // System.out.println(sp1);   // ��ü �ּҰ� ���

	SmartPhone sp2 = new SmartPhone("Galaxy S7");
	// System.out.println(sp2);   // ��ü �ּҰ� ���
	
	// sp1 �ּҰ��� sp2�� �Ҵ�
	sp2 = sp1;
	System.out.println(sp1.getModel());
	System.out.println(sp2.getModel());
	}
}
