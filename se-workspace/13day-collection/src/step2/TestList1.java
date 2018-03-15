package step2;

import java.util.ArrayList;

public class TestList1 {
	public static void main(String[] args) 
	{
		String name = "아이유";
		ArrayList al = new ArrayList();
		
		al.add(name);
		
		// 첫 번째 요소를 반환받는다.
		// Generic을 적용하지 않으면 
		// 최상위 Object 클래스 타입으로 저장되고 반환되므로. 
		// String 클래스의 메서드인 length를 호출하기 위해서는 
		// Object Casting 절차가 필요하다.
		String str = (String) al.get(0);
		System.out.println(str.length());
		
		al.add("아이유");
		System.out.println(al);
		
		al.add("장기하");
		al.add("아이유");
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i));
		}
		
		System.out.println("0번 인덱스 요소 삭제 : " + al.remove(0));
		System.out.println(al);
		
		System.out.println("삭제 : " + al.remove("아이유"));
		System.out.println(al);
		
		al.clear();
		System.out.println(al);
	}
}
