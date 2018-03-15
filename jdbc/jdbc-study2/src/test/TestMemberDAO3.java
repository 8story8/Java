package test;

import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO3 
{
	public static void main(String[] args) 
	{
		try 
		{
			MemberDAO dao = new MemberDAO();
			
			ArrayList<MemberVO> al = dao.getAllMemberList();
			
			for(int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
