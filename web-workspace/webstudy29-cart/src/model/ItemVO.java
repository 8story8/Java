package model;

public class ItemVO {
	private int itemNo;
	private String itemName;
	private String itemMaker;
	private int itemPrice;
	private String itemDetail;
	
	public ItemVO() {
	}
	
	public ItemVO(int itemNo, String itemName, String itemMaker) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemMaker = itemMaker;
	}
	
	public ItemVO(String itemName, String itemMaker, int itemPrice, String itemDetail) {
		super();
		this.itemName = itemName;
		this.itemMaker = itemMaker;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
	}

	public ItemVO(int itemNo, String itemName, String itemMaker, int itemPrice, String itemDetail) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemMaker = itemMaker;
		this.itemPrice = itemPrice;
		this.itemDetail = itemDetail;
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
	
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	
	public String getItemDetail() {
		return itemDetail;
	}

	@Override
	public String toString() {
		return "ItemVO [itemNo=" + itemNo + ", itemName=" + itemName + ", itemMaker=" + itemMaker + ", itemPrice="
				+ itemPrice + ", itemDetail=" + itemDetail + "]";
	}
}
