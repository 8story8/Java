package test;

import model.MemberDAO;
import model.MemberVO;

// 아이디로 회원 검색

public class TestMemberDAO1 
{
	public static void main(String[] args) 
	{
		try
		{
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.findMemberById("jin");
			if(vo != null)
			{
				System.out.println("검색 결과 : " + vo);
			}
			else
			{
				System.out.println("검색 결과 없음");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
