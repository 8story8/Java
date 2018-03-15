package step2;

public class TestVariableScope {
	private int i;   // Instance Variable : Heap ������ ����, �⺻ �ʱ�ȭ 0
	public void test1()
	{
		int j;   // Local Variable
		System.out.println(i);   // �⺻ �ʱ�ȭ�Ǿ� 0 ���
		// System.out.println(j);   //Error, j�� Local Variable�̹Ƿ� �ʱ�ȭ �ʿ�
		int k = 0;   // Local Variable�� ����� �ʱ�ȭ�� �ؾ� ��� ����
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
		System.out.println(i);   // i�� Instance Variable�̹Ƿ� ��� ����
		// System.out.println(j);   // j�� Local Variable�̹Ƿ� test2() �������� ��� ����
	}
	
	public void test4()
	{
		if(i < 0)
		{
			int k = 5;
		}
		// System.out.println(k);   // Local Variable k�� ����� �ڽ��� ���� ���� �������� ��� ����
		// test5()���� �ڵ带 ����
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
		main Method�� static�̹Ƿ� ���� Ŭ������ �޼����
		��ü�� �����ؼ� ȣ���ؾ� �Ѵ�.
		*/
		TestVariableScope t = new TestVariableScope();
		t.test1();
	}

}
