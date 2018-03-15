package step2;

public class TestOperator1 {
	public static void main(String[] args) {
		int i = 7;
		int j = 3;
		
		System.out.println(i * j);
		System.out.println(i / j);
		System.out.println(i % j);   // i를 j로 나눈 나머지
		System.out.println(i == j);   // i와 j가 같은 값인지 비교하여 true or false
		System.out.println(i != j);   // i와 j가 다른 값인지 비교하여 true or false
		
		System.out.println("********************");
		
		boolean flag = false;
		
	    System.out.println(flag);
	    System.out.println(!flag);
	    
	    System.out.println("********************");
	    
	    int k = 7;
	    
	    System.out.println(k++);   // 실행 후 증가, k = 7
	    System.out.println(k);   // k = 8
	    
	    System.out.println(++k);   // 증가 후 실행, k = 9
	    System.out.println(k);   // k = 9
	    
	    System.out.println("********************");
	    
	    // int k = 9
	    System.out.println(--k);   // k = 8
	    System.out.println(k--);   // k = 8
	    System.out.println(k);   // k = 7
	    
	    System.out.println("********************");
	    
	    int balance = 100;
	    
	    // balance = balance + 200;
	    // 위 코드를 줄여서 표현
	    balance += 200;
	    
	    System.out.println(balance);
	    
	    System.out.println("********************");
	    
	    /*
	    "&"와 "|" 연산과 "&&"와 "||" 연산은 결과가 같으나 성능 차이가 존재
	    
	    and 연산
	    true & true -> true
	    true & false -> false
	    false & true -> false
	    false & false -> false
	    "&&" 연산자를 이용하면 and 연산일 경우
	    flase가 처음 도출되면 다음 연산은 생략하고
	    결론 도출(성능 향상)
	    
	    or 연산
	    true | true -> true
	    true | false -> true
	    false | true -> true
	    false | false -> false
	    "||" 연산자를 이용하면 선행 조건 결과가 true이면
	    다음 조건을 연산하지 않고
	    바로 true로 결론 도출
	     */	    
	    
	    System.out.println(true || false);
	    System.out.println(true && false);
	    
	    System.out.println("********************");
	    
	    // 삼항 연산자
	    int x = 10;
	    
	    // (조건식) ? 식1 : 식2
	    // 조건식이 참이면 식1 수행, 거짓이면 식2 수행
	    int result = (x>0) ? x+1 : x+2;
	    
	    System.out.println(result);
	    
	}
}
