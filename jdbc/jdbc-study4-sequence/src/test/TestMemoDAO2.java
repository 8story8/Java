package test;

import java.util.ArrayList;
import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO2 
{
	public static void main(String[] args) 
	{
		try
		{
			MemoDAO dao = new MemoDAO();
			ArrayList<MemoVO> list = dao.getAllMemoList();
		
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
