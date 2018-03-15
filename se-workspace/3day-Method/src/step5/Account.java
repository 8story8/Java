package step5;

public class Account {
	
	// private 접근제어자로 외부 접근 차단
	private int money;
	private String name;
	
	// public setter/getter로 간접 접근
	// setter : 외부에서 정보를 할당할 때 사용
	public void setMoney(int m) {
		money = m;
	}
	
	// getter method : 외부로 정보를 리턴할 때 사용
	public int getMoney() {
		return money;
	}
	
	// setter : 외부에서 정보를 할당할 때 사용
	public void setName(String n) {
		name = n;
	}
		
	// getter method : 외부로 정보를 리턴할 때 사용
	public String getName() {
		return name;
	}
}
