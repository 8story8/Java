package step5;

public class RentCar {
	private String model;
	private int price;
	public RentCar(String model, int price)
	{
		this.model = model;
		this.price = price;
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
	
	
}
