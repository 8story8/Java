package step4;

import java.util.StringTokenizer;

public class TestStringTokenizer 
{
	public static void main(String[] args) 
	{
		String str1 = "���� �� ���� ��������.";
		
		// ������ �������� ���ڿ��� �ڸ���.
		StringTokenizer stk1 = new StringTokenizer(str1);
		while(stk1.hasMoreTokens())
		{
			System.out.println(stk1.nextToken());		
		}
		
		System.out.println("********************");
		
		String str2 = "������ũ,����,ġ��,����,�Ŷ��,����,ġŲ";
		StringTokenizer stk2 = new StringTokenizer(str2, ",");
		while(stk2.hasMoreTokens())
		{
			System.out.println(stk2.nextToken());		
		}
	}
}
