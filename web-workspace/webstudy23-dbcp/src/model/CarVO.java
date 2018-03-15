package model;

public class CarVO {
	private String carNo;
	private String carModel;
	private String carPrice;
	
	public CarVO(String carNo, String carModel, String carPrice) {
		super();
		this.carNo = carNo;
		this.carModel = carModel;
		this.carPrice = carPrice;
	}
	
	public String getCarNo() {
		return carNo;
	}
	
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public String getCarPrice() {
		return carPrice;
	}
	
	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}
}
