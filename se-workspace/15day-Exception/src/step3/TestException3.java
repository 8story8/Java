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
			System.out.println("리스트 범위를 초과하여 요소 반환 X");
		}
		
		System.out.println("정상 수행 후 종료");
	}
}
