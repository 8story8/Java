package test;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO 
{
	public static void main(String[] args) 
	{
		try
		{
			MemoDAO dao = new MemoDAO();
			
			dao.insertMemo(new MemoVO("���� �޴�", "�ɵ��"));
			
			System.out.println("Memo Registration OK");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
