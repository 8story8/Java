package test;

import model.MemberDAO;

public class TestMemberDAO5 
{
	public static void main(String[] args) 
	{
		try
		{
			MemberDAO dao = new MemberDAO();
			
			String address = "�Ǳ�";
			int count = dao.getMemberCountByAddress(address);
			
			System.out.println(address + "�� ��� ȸ�� �� : " + count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
