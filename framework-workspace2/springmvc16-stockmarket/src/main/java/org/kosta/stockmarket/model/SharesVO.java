package org.kosta.stockmarket.model;

public class SharesVO {
	private String id;
	private String symbol;
	private int quantity;
	private int totalPrice;
	
	public SharesVO() {
		super();		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "SharesVO [id=" + id + ", symbol=" + symbol + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}
}






