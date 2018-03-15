package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO3 
{
	public static void main(String[] args)
	{
		try
		{
			ProductDAO dao = new ProductDAO();   // Constructor¿¡¼­ Driver Loading
			
			int highPrice = 150;
			int lowPrice = 120;
			
			ArrayList<ProductVO> list = dao.getProductListByPrice(lowPrice, highPrice);
			
			for(int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
