package step1;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet2 {

	public static void main(String[] args) 
	{
		// Set 계열 TreeSet 클래스에 Generic 적용하는 예제
		// 아래 set에는 String 타입의 요소만 추가될 수 있도록 Generic을 적용
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("김래현");
		ts.add("신용혁");
		// ts.add(1);   // Compile Error : String 타입만 가능하게 Generic이 선언

		ts.add("하현우");
		ts.add("신용혁"); // 중복 허용 안함
		System.out.println(ts);
		
		System.out.println("********************");
		
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		hs.add("A");
		hs.add("D");
		hs.add("B");
		System.out.println(hs);   // 추가된 순서를 기억하여 A, D, B가 출력
	}
}
