package step8;

public class MemberService 
{
	public void register(String nickName) throws NickNameException 
	{
		if(nickName.length() < 2 || nickName.length() > 5)
		{
			throw new NickNameException(nickName +" �г����� ��ϵ� �� �����ϴ�(2�� ���� 5�� ���ϸ� ����)");
		}
		
		System.out.println(nickName + " ī�� ��� �Ϸ�");
	}
}
