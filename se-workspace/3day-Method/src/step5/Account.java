package step5;

public class Account {
	
	// private ���������ڷ� �ܺ� ���� ����
	private int money;
	private String name;
	
	// public setter/getter�� ���� ����
	// setter : �ܺο��� ������ �Ҵ��� �� ���
	public void setMoney(int m) {
		money = m;
	}
	
	// getter method : �ܺη� ������ ������ �� ���
	public int getMoney() {
		return money;
	}
	
	// setter : �ܺο��� ������ �Ҵ��� �� ���
	public void setName(String n) {
		name = n;
	}
		
	// getter method : �ܺη� ������ ������ �� ���
	public String getName() {
		return name;
	}
}
