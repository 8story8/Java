package model;

public class PersonVO {
	private String name;
	private int money;
	private CarVO car;
	
	public PersonVO() {
		super();
	}
	
	public PersonVO(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public CarVO getCar() {
		return car;
	}

	public void setCar(CarVO car) {
		this.car = car;
	}
}
