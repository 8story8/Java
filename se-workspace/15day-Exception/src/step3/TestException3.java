package step3;

import java.util.ArrayList;

public class TestException3 
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();
		
		try
		{
		System.out.println(al.get(0));
		}
		catch(IndexOutOfBoundsException ie)
		{
			System.out.println("����Ʈ ������ �ʰ��Ͽ� ��� ��ȯ X");
		}
		
		System.out.println("���� ���� �� ����");
	}
}
