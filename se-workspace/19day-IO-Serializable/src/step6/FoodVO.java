package step6;

import java.io.Serializable;

public class FoodVO implements Serializable
{
	private String name;
	private int price;
	
	public FoodVO(String name, int price) 
	{
		super();
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	public int getPrice() 
	{
		return price;
	}
}
