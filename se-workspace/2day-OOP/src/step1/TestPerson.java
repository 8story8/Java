// Package 선언하여 step1 디렉토리 아래에 TestPerson class 저장

package step1;

/*
TestPerson class는 Person class를 이용해
Object 생성하고 속성에 Data를 할당해보고
Person 객체의 기능을 실행해보는 역할
Person class : Person 객체를 생성하기 위한 틀
TestPerson class : Main Method를 명시하여 Program의 시작을 가능하게 하고
다른 Class를 이용해 객체 생성 및 제어를 테스트
 */

public class TestPerson {
	/*
	Main Method는 Java Program의 시작점
	 */
	
	public static void main(String[] args) {
		    /* 
		    Person class를 이용해 Object 생성
		    Person : Data Type(Reference Data Type)
		    p : 변수명(Reference Variable)
		    = 할당 or 대입
		    new : Object 생성시 명시하는 Java Keyword
		    Person() : 생성자(Constructor)
		     */
		
			Person p = new Person();
			p.name = "문성준";   // 변수(속성)에 이름 저장
			System.out.println(p.name);   // 저장한 이름 출력
			
			// Object를 한번 더 생성
			Person p2 = new Person();
			
			// p2 객체의 name에 장기하를 할당
			p2.name = "장기하";
			System.out.println(p2.name);
			// p2 객체의 name을 출력
			
			// p, p2 객체의 study Method를 호출
			p.study();
			p2.study();
	}
}
