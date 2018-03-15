package step4;

public class TestString {
	// 문자열 비교 관련 예제
	
	public static void main(String[] args) {
		String name1 = "아이유,설현,장기하";
		// String class의 메서드를 이용해
		// 특정 구분자를 중심으로 문자열 정보를 각각의 배열 요소로 나누어 출력
		String na[] = name1.split(",");
		
		for(int i = 0; i < na.length; i++)
		{
			System.out.println(na[i]);
		}
		
		System.out.println("********************");
		
		// java에서 문자열을 생성하는 방법은 다양하다.
		String str1 = "설현";
		String str2 = new String("설현");
		System.out.println(str1);
		System.out.println(str2);
		
		StringBuilder sb = new StringBuilder("설현");
		System.out.println(sb);									// 설현
		
		System.out.println(str1 == str2);						// false
		System.out.println(str1 == sb.toString());			// false
		
		// 문자열 비교는 == 연산으로 하는 것이 아니라
		// String class의 equals 메서드를 이용
		System.out.println(str1.equals(str2));					// true
		System.out.println(str1.equals(sb.toString()));		// true
		
	}
}
