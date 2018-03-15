package step6;

public class TestHasA {
	public static void main(String[] args) {
		
		Student stu = new Student("������", "15", new SmartPhone("Galaxy S7", 100));
		
		System.out.println(stu.getName() + " " + stu.getStuId());	// ������ 15
		System.out.println(stu.getSmartPhone().getModel());			// Galaxy S7
		System.out.println(stu.getSmartPhone().getPrice());			// 100
		
		// stu ��ü�� ����Ʈ�� �𵨸��� �����ؼ� iPhone 7 ���
		stu.getSmartPhone().setModel("iPhone 7");						
		System.out.println(stu.getSmartPhone().getModel());			// iPhone 7
	
	}
}
