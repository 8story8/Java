package school;

import java.util.ArrayList;
import java.util.Iterator;

public class SchoolService
{
	private ArrayList<Person> al = new ArrayList<Person>();   // 구성원 정보가 할당될 ArrayList al 변수

	public int findIndexByTel(String tel)   // 구성원 정보 요소의 번호 return 메서드
	{
		int index = -1;
		
		for(int i = 0; i < al.size(); i++)
		{
			if(tel.equals(al.get(i).getTel()))   // 입력된 전화 번호가 존재하는 구성원 정보의 전화 번호와 일치하면
			{
				index = i;   // 해당 요소의 번호를 index 변수에 할당하고,
				break;   // break를 통해 for문을 탈출
			}	
		}
		
		return index;  // tel에 상응하는 구성원의 정보가 없으면 -1, 있으면 tel에 상응하는 구성원의 정보 요소의 번호를 return
	}
	
	public void addPerson(Person p) throws DuplicateTelException   // 구성원 정보 추가 메서드, p.getTel() + "번호가 존재하여 추가 불가!"를 호출하는 곳으로 전송
	{
		if(findIndexByTel(p.getTel()) != -1)   // 입력받은 전화 번호가 중복이면
		{
			throw new DuplicateTelException(p.getTel() + "번호가 존재하여 추가 불가!");  // 전화 번호 중복에 대한 예외를 발생
		}
		
		al.add(p);   // 구성원 정보를 ArrayList al 변수에 추가
	}

	public Person findPersonByTel(String findTel) throws PersonNotFoundException   // 구성원 정보 검색 메서드, findTel + "번호가 존재하지 않아 조회 불가!"를 호출하는 곳으로 전송
	{
		int index = findIndexByTel(findTel);   // findTel에 상응하는 구성원 정보 요소의 번호를 index에 할당
		
		if(index == -1)   // 입력받은 전화 번호가 존재하지 않으면
		{
			throw new PersonNotFoundException(findTel + "번호가 존재하지 않아 조회 불가!");   // 전화 번호가 존재하지 않음에 대한 예외를 발생
		}
		
		return al.get(index);   // findTel에 상응하는 구성원의 정보가 없으면 위의 예외 처리를 실행, 있으면 findTel에 상응하는 구성원의 정보 객체를 return
	}

	public void updatePerson(Person p) throws PersonNotFoundException   // 구성원 정보 수정 메서드, p.getTel() + "번호가 존재하지 않아 수정 불가!"를 호출하는 곳으로 전송
	{
		int index = findIndexByTel(p.getTel());   // Person p의 전화 번호에 상응하는 구성원 정보 요소의 번호를 index에 할당
		
		if(index == -1)    // 입력받은 전화 번호가 존재하지 않으면
		{
			throw new PersonNotFoundException(p.getTel() + "번호가 존재하지 않아 수정 불가!");
		}
		
		al.set(index, p);   // Person p의 전화 번호에 상응하는 구성원 정보를 ArrayList al 변수에서 수정
	}

	public void deletePersonByTel(String delTel) throws PersonNotFoundException   // 구성원 정보 삭제 메서드, delTel + "번호가 존재하지 않아 삭제 불가!"를 호출하는 곳으로 전송
	{
		int index = findIndexByTel(delTel);   // delTel에 상응하는 구성원 정보 요소의 번호를 index에 할당
		
		if(index == -1)   // 입력받은 전화 번호가 존재하지 않으면
		{
			throw new PersonNotFoundException(delTel + "번호가 존재하지 않아 삭제 불가!");    // 전화 번호가 존재하지 않음에 대한 예외를 발생
		}
		
		al.remove(index);   // 구성원 정보를 ArrayList al 변수에서 삭제
	}
	
	public void printAll() 
	{
		Iterator<Person> it = al.iterator();   // Collection의 정보를 반복해서 열거해주는 Iterator 인터페이스를 Person 객체로 Generic
													  // ArrayList al 변수의 iterator() 메서드를 Overriding하여 Iterator it에 할당
		
		while(it.hasNext())   // al 변수 안에 구성원 정보가 존재하면
		{
			System.out.println(it.next());   // 차례대로 열거하여 출력
		}
	}
}