package step6;

import step4.Car;
import step5.MemberVO;
import java.util.Date;

public class TestImport {

	public static void main(String[] args) {
		MemberVO mvo = new MemberVO("KTX", "������");
		System.out.println(mvo.getId() + " " + mvo.getName());
		
		Car c = new Car("�ҳ�Ÿ");
		System.out.println(c.getModel());
		
		Date d = new Date();
		System.out.println(d.toString());
	}

}
