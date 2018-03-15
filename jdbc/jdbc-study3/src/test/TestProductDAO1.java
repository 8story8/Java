package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO1 
{
	public static void main(String[] args)
	{
		try
		{
			ProductDAO dao = new ProductDAO();   // Constructor에서 Driver Loading
			ProductVO pvo = dao.findProductById("a");
			System.out.println(pvo);   // 상품 정보가 없으면 null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
