package step2;

public class House {
	private String address;   // Instance Variable
	private int price;
	
	public void setAddress(String address)   // Local Variable
	{
		// this Ű���带 �̿��� Instance Variable�� ����Ų��.
		this.address = address;
	}
	
	public String getAddress()
	{
		return this.address;   // = return address;
	}
	
	public void setPrice(int price)   
	{
		this.price = price;
	}
	
	public int getPrice()
	{
		return this.price;   // = return price;
	}

}
