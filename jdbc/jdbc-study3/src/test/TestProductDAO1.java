package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO1 
{
	public static void main(String[] args)
	{
		try
		{
			ProductDAO dao = new ProductDAO();   // Constructor���� Driver Loading
			ProductVO pvo = dao.findProductById("a");
			System.out.println(pvo);   // ��ǰ ������ ������ null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
