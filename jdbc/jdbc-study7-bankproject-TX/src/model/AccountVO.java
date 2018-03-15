package model;

// VO : Value Object

public class AccountVO 
{
	private String num;
	private String name;
	private String password;
	private int balance;
	
	public AccountVO(String name, String password, int balance)
	{
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	
	public AccountVO(String num, String name, String password, int balance)
	{
		super();
		this.num = num;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() 
	{
		return "AccountVO [num=" + num + ", name=" + name + ", password=" + password + ", balance=" + balance + "]";
	}
}
