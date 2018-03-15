package step5;

import java.util.ArrayList;

public class CartService 
{
	private ArrayList<ProductVO> al = new ArrayList<ProductVO>(); 

	public void addProduct(ProductVO pvo) 
	{
		al.add(pvo);
	}

	public void printAllName() 
	{
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i).getName());
		}
	}

	public ArrayList<ProductVO> findProductByMaker(String maker) 
	{
		ArrayList<ProductVO> reList = new ArrayList<ProductVO>();
	
		for(int i = 0; i < al.size(); i++)
		{
			if(maker.equals(al.get(i).getMaker()))
			{
				reList.add(al.get(i));
			}
		}
		
		return reList;
	}
}
