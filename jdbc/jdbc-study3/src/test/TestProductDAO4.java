package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO4 
{
	public static void main(String[] args)
	{
		try
		{
			ProductDAO dao = new ProductDAO();   // Constructor¿¡¼­ Driver Loading
		
			ArrayList<String> list = dao.getProductMakerKind();
			
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
