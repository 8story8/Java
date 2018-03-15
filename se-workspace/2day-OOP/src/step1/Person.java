/*
Package는 Class를 효과적으로 분류하기 위해 사용
Step1 디렉토리 아래에 Person.class가 생성
Class : Object 생성을 위한 틀
Object는 Variable과 Method로 구성
 */

package step1;

public class Person {
	/* 
	속성 or 변수 or Variable or Attribute or Field
	String : Data Type 중 문자열 Data를 저장할 때 사용
	name : 변수 이름
	*/
	
	String name;
	
	/* 
	기능 or Method or Operation
	public : Access Modifier의 종류 중 하나
	void : Return 값이 없을 때 명시하는 Java Keyword
	study : Method 이름
	() : Parameter 명시 영역(선택적)
	 */
	
	public void study()
	{
		// IO Console에 출력
	    System.out.println(name+" 공부하다.");
	}
}
