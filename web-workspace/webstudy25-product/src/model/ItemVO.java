package model;

public class ItemVO {
	private int itemNo;
	private String itemName;
	private String itemMaker;
	private int itemPrice;
	private String itemDate;
	
	public ItemVO() {
	}

	public ItemVO(String itemName, String itemMaker, int itemPrice) {
		super();
		this.itemName = itemName;
		this.itemMaker = itemMaker;
		this.itemPrice = itemPrice;
	}
	
	public ItemVO(int itemNo, String itemName, String itemDate) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemDate = itemDate;
	}
	
	public ItemVO(int itemNo, String itemName, String itemMaker, int itemPrice, String itemDate) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemMaker = itemMaker;
		this.itemPrice = itemPrice;
		this.itemDate = itemDate;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	public int getItemNo() {
		return itemNo;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemMaker(String itemMaker) {
		this.itemMaker = itemMaker;
	}
	
	public String getItemMaker() {
		return itemMaker;
	}
	
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getItemPrice() {
		return itemPrice;
	}
	
	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}
	
	public String getItemDate() {
		return itemDate;
	}
}
