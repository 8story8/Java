package step6;

public class TestHasA {
	public static void main(String[] args) {
		
		Student stu = new Student("아이유", "15", new SmartPhone("Galaxy S7", 100));
		
		System.out.println(stu.getName() + " " + stu.getStuId());	// 아이유 15
		System.out.println(stu.getSmartPhone().getModel());			// Galaxy S7
		System.out.println(stu.getSmartPhone().getPrice());			// 100
		
		// stu 객체의 스마트폰 모델명을 수정해서 iPhone 7 출력
		stu.getSmartPhone().setModel("iPhone 7");						
		System.out.println(stu.getSmartPhone().getModel());			// iPhone 7
	
	}
}
