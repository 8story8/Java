package step3;
// VO(Value Object), DTO(Data Transfer Object), DAO(Data Access Object)
// Service : Business Logic

public class ItemVO {
	private String model;
	private int price;
	
	public ItemVO(String model, int price) {
		this.model = model;
		this.price = price;
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
