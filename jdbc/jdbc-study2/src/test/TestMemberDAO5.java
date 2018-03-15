package test;

import model.MemberDAO;

public class TestMemberDAO5 
{
	public static void main(String[] args) 
	{
		try
		{
			MemberDAO dao = new MemberDAO();
			
			String address = "판교";
			int count = dao.getMemberCountByAddress(address);
			
			System.out.println(address + "에 사는 회원 수 : " + count);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
