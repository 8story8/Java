package test;

import model.MemberDAO;
import model.MemberVO;

/*
Update ȸ�� ���� ����
*/

public class TestMemberDAO4 
{
	public static void main(String[] args) 
	{
		try 
		{
			MemberDAO dao = new MemberDAO();
			System.out.println("���� �� : " + dao.findMemberById("bourbon"));
			MemberVO vo = new MemberVO("bourbon", "tpdlepsdprkwk", "Zoker", "�Ϻ�");
			dao.updateMember(vo);
			System.out.println("���� �� : " + dao.findMemberById("bourbon"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
