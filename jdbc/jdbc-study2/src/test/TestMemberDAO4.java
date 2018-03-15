package test;

import model.MemberDAO;
import model.MemberVO;

/*
Update 회원 정보 수정
*/

public class TestMemberDAO4 
{
	public static void main(String[] args) 
	{
		try 
		{
			MemberDAO dao = new MemberDAO();
			System.out.println("수정 전 : " + dao.findMemberById("bourbon"));
			MemberVO vo = new MemberVO("bourbon", "tpdlepsdprkwk", "Zoker", "일본");
			dao.updateMember(vo);
			System.out.println("수정 후 : " + dao.findMemberById("bourbon"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
