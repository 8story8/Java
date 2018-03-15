package step1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class TestIterator 
{
	public static void main(String[] args) 
	{
		// ArrayList<String> al = new ArrayList<String>();
		Collection<String> c1 = new ArrayList<String>();
		
		c1.add("피자");
		c1.add("짜장면");
		c1.add("짬뽕");
		
		Iterator<String> it1 = c1.iterator();
		
		while(it1.hasNext())   // 다음 요소가 존재하면 true, 존재하지 않으면 false
		{
			System.out.println(it1.next());   // 다음 요소를 반환
		}
		
		System.out.println("********************");
		
		Collection<String> c2 = new TreeSet<String>();
		c2.add("민정수석");
		c2.add("민정수석");
		c2.add("정무수석");
		
		Iterator<String> it2 = c2.iterator();
		while(it2.hasNext())
		{
			System.out.println(it2.next());
		}
		/*
		ArrayList, TreeSet과 같은 Collection 인터페이스의 하위 구현체는
		Collection 인터페이스의 iterator() 추상 메서드를 구현했기 때문에,
		iterator() 메서드 호출 후 반환되는 Iterator로 Set이든 List든 관계없이
		표준화된 방식으로 요소들을 반복 열거할 수 있다.
		*/
	}
}
