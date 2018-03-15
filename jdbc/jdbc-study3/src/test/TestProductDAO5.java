package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO5 
{
	public static void main(String[] args)
	{
		try
		{
			int percent = 20;
			ProductDAO dao = new ProductDAO();   // Constructor¿¡¼­ Driver Loading
		
			ArrayList<ProductVO> list = dao.getProductListDiscountPrice(percent);
			
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
