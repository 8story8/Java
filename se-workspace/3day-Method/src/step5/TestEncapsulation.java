package step5;

public class TestEncapsulation {

	public static void main(String[] args) {
		Account a = new Account();
		// money�� private���� ����Ǿ� ���� �Ұ�!
		// System.out.println(a.money);
		
		// setter�� �����Ͽ� ������ �Ҵ�
		a.setMoney(100);
		System.out.println(a.getMoney());
		
		// setter�� �����Ͽ� ������ �Ҵ�
		a.setName("������");
		System.out.println(a.getName());
	}
}
