package step3;
/*
Class내에서 Constructor를 명시하지 않으면,
Compile시에 Default Constructor를 자동 삽입
Person(){} --> Default Constructor
 */
public class Person {
	/*
	생성자를 명시
	생성자 이름은 클래스 이름과 동일
	아래 생성자는 객체 생성시 호출
    */
	public Person(){
		System.out.println("Person 생성자 실행");
	};
}
