package step6;

public class SmartPhone {
	
	private String model;
	private int price;
	
	SmartPhone(String model, int price)
	{
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
}
