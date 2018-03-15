package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO2 
{
	public static void main(String[] args) 
	{
		try
		{
			ProductDAO dao = new ProductDAO();   // Constructor에서 Driver Loading
			ProductVO vo = new ProductVO("e", "iPhone 7", "Apple", 170);
			ProductVO pvo = dao.findProductById(vo.getId());
			
			if(pvo == null)
			{
				dao.registerProduct(vo);
				System.out.println(vo + " Insert OK");
			}
			else
			{
				System.out.println(vo.getId() + " 아이디가 존재하므로 추가 불가!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
