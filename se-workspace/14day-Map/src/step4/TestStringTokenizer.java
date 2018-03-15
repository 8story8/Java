package step4;

import java.util.StringTokenizer;

public class TestStringTokenizer 
{
	public static void main(String[] args) 
	{
		String str1 = "새해 복 많이 받으세요.";
		
		// 공란을 기준으로 문자열을 자른다.
		StringTokenizer stk1 = new StringTokenizer(str1);
		while(stk1.hasMoreTokens())
		{
			System.out.println(stk1.nextToken());		
		}
		
		System.out.println("********************");
		
		String str2 = "스테이크,와인,치즈,피자,컵라면,소주,치킨";
		StringTokenizer stk2 = new StringTokenizer(str2, ",");
		while(stk2.hasMoreTokens())
		{
			System.out.println(stk2.nextToken());		
		}
	}
}
