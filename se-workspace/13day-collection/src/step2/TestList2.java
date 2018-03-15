package step2;

import java.util.ArrayList;

public class TestList2 {
	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		
		al1.add(new Person("장기혁", 30));
		
		// al1의 첫 번째 요소의 나이를 출력
		// Object 타입으로 반환되므로 Object Casting해야 getAge();를 호출할 수 있다.
		Person p = (Person) al1.get(0);
		System.out.println(p.getAge());
		
		System.out.println("********************");
		
		al1.add(new Person("정현지", 26));
		al1.add(new Person("배서경", 24));
		
		// for문을 이용해서 al1의 name을 출력
		for(int i = 0; i < al1.size(); i++){
			// System.out.println(((Person) al1.get(i)).getAge());
			// 위 라인을 풀어서 쓴다면
			Person temp = (Person) al1.get(i);
			System.out.println(temp.getName());
		}
		
		System.out.println("********************");
		
		// 위 코드를 Generic을 적용하면 아래와 같다.
		ArrayList<Person> al2 = new ArrayList<Person>();

		al2.add(new Person("아이유", 24));
		al2.add(new Person("장기하", 30));
		
		// 첫 번째 요소의 이름을 반환받아 출력
		// Generic을 적용했으므로 변도의 캐스팅 절차가 필요 없다.
		System.out.println(al2.get(0).getName());
	
		System.out.println("********************");
		
		al2.add(new Person("하현우", 32));
		
		// for문을 이용해 30세 이상 Person의 name을 출력
		for(int i = 0; i < al2.size(); i++){
			if(al2.get(i).getAge() >= 30){
				System.out.println(al2.get(i).getName());
			}
		}
	}
}
