package model;

public class ProductVO 
{
	String id;
	String name;
	String maker;
	int price;
	
	public ProductVO(String id, String name, String maker, int price) 
	{
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setMaker(String maker) 
	{
		this.maker = maker;
	}
	
	public String getMaker()
	{
		return maker;
	}
	
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	public int getPrice() 
	{
		return price;
	}
	
	public String toString()
	{
		return "id : " + id + ", name : " + name + ", maker : " + maker + ", price : " + price;
	}
}
