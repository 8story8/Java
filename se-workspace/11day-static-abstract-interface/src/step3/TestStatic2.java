package step3;

class Person
{
	int money = 100;
	static int sMoney = 200;
	
	public void test1()   // Object�� Member �޼���
	{
		System.out.println(money);
		System.out.println(sMoney);
		test2();
		test3();
		test4();
	}
	
	public static void test2()
	{
		System.out.println(sMoney);
		/// System.out.println(money);   // �̿��ϱ� ���ؼ��� ��ü ������ �ʿ��ϴ�. 
												  // test2�� static �޼����̹Ƿ� ��ü �������� �ܺο��� Ŭ���������� ���� �����ϰ�,
		  										  // �����Ϸ��� �ϴ� money�� Instance Variable�̹Ƿ� �ݵ�� ��ü ������ ����ؾ�
												  // money�� �޸𸮿� ����ȴٴ� ������ �� �� �ֱ� �����̴�.
		// test3();   							  // ���� ������ Error
		test4();
	}
	
	public void test3()
	{
		
	}
	
	public static void test4()
	{
		
	}
}

public class TestStatic2 
{
	public static void main(String[] args) 
	{


	}
}
