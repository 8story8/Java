package test;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO2 
{
	public static void main(String[] args) 
	{
		try 
		{
			MemberDAO dao = new MemberDAO();
			MemberVO vo = new MemberVO("jQuery", "javaserverpage", "하이바라", "베를린");
			
			if(dao.findMemberById(vo.getId()) == null)
			{
				dao.registerMember(vo);
				System.out.println(vo + " Insert OK!");
			}
			else
			{
				System.out.println("회원 아이디가 존재합니다!");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
