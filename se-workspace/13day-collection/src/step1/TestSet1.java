package step1;

import java.util.Set;
import java.util.TreeSet;

public class TestSet1 
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add("장기하");
		ts.add("하현우");
		System.out.println(ts.size());
		
		ts.add("하현우");   // 중복되므로 추가 안됨
		System.out.println(ts.size());
		
		// toString()이 Overriding되어 주소값 대신 Set의 실제 요소가 반환되어 출력
		System.out.println(ts);
		ts.add("김래현");
		
		// TreeSet은 정렬 기능이 내장되어 있어서 가, 나, 다 순으로 출력
		System.out.println(ts);
		
		ts.clear();
		System.out.println(ts);
		
		ts.add("b");
		ts.add("a");
		ts.add("c");
		System.out.println(ts);
		
		ts.clear();
		System.out.println(ts);
		
		ts.add("5");
		ts.add("3");
		ts.add("4");
		System.out.println(ts);
		
		System.out.println(ts.last());
	}
}
