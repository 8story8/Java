package step7;

class Car{
	private String model;
	private int price;
	private String color;
	
	// Constructor Overloading : 다양한 Option으로 Object를 생성할 수 있게 한다.
	Car(){ }
	
	Car(String model)
	{
		this.model = model;
	}
	
	Car(String model, int price)
	{
		this.model = model;
		this.price = price;
	}
	
	Car(String model, int price, String color)
	{
		this(model, price);
		this.color = color;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}

public class TestConstructorOverloading {

	public static void main(String[] args) {
		// 아래와 같이 다양한 Option으로 Object 생성을 할 수 있다.
		/*
		Car c1 = new Car();
		Car c2 = new Car("모닝");
		Car c3 = new Car("스파크", 100);
		*/
	}
}
