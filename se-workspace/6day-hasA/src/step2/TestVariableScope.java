package step2;

public class TestVariableScope {
	private int i;   // Instance Variable : Heap 영역에 저장, 기본 초기화 0
	public void test1()
	{
		int j;   // Local Variable
		System.out.println(i);   // 기본 초기화되어 0 출력
		// System.out.println(j);   //Error, j는 Local Variable이므로 초기화 필요
		int k = 0;   // Local Variable은 명시적 초기화를 해야 사용 가능
		System.out.println(k);
	}
	
	public void test2(int i)
	{
		System.out.println(i);   // Local Variable
		System.out.println(this.i);   // Instance Variable
		int j = 2;
	}
	
	public void test3()
	{
		System.out.println(i);   // i는 Instance Variable이므로 사용 가능
		// System.out.println(j);   // j는 Local Variable이므로 test2() 내에서만 사용 가능
	}
	
	public void test4()
	{
		if(i < 0)
		{
			int k = 5;
		}
		// System.out.println(k);   // Local Variable k는 선언된 자신의 실행 영역 내에서만 사용 가능
		// test5()에서 코드를 변경
	}
	
	public void test5()
	{
		int k = 0;
		if(i <= 0)
		{
			k = 5;
		}
		System.out.println(k);
	}
	
	public static void main(String[] args) {
		/* 
		main Method는 static이므로 같은 클래스의 메서드라도
		객체를 생성해서 호출해야 한다.
		*/
		TestVariableScope t = new TestVariableScope();
		t.test1();
	}

}
