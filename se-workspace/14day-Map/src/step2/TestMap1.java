package step2;

import java.util.HashMap;

public class TestMap1 
{
	public static void main(String[] args) 
	{
		HashMap hm = new HashMap();
		
		// key, value 쌍으로 저장
		hm.put("1", new Person("아이유", 24));
		hm.put("2", new Person("장기하", 30));
		
		// key가 2인 사람의 이름을 반환받아 출력
		//Generic을 적용하지 않았으므로 최상위 클래스 타입인 Object형으로 반환
		// getName()을 호출하기 위해서는 Object Casting이 필요하다.
		Person p = (Person)hm.get("2");
		System.out.println(p.getName());
		
		System.out.println("********************");
		
		// Generic 적용 Map
		HashMap<String, Person> ghm = new HashMap<String, Person>();
		
		// "a" key의 이름을 반환받아 출력
		ghm.put("a", new Person("기성용", 30));
		System.out.println(ghm.get("a"));
		
		System.out.println("********************");
		
		// 동일한 "a" key의 이름을 반환받아 출력
		ghm.put("a", new Person("손흥민", 26));
		System.out.println(ghm.get("a"));
		
		System.out.println("********************");
		
		// "bb" key의 존재 유무 파악
		ghm.put("b", new Person("메시", 30));	
		boolean flag = ghm.containsKey("bb");
		System.out.println("key의 존재 유무 : " + flag);
		
		System.out.println("********************");
		
		// "a" key 요소를 삭제
		System.out.println(ghm.remove("a") + " 삭제");
		System.out.println(ghm);
	}
}
