package step2;

class ErrorEx
{
	public void a()
	{
		System.out.println("a Method ����");
		b();
	}
	
	public void b()
	{
		System.out.println("b Method ����");
		a();
	}
}

public class TestError 
{
	public static void main(String[] args) 
	{
		ErrorEx e = new ErrorEx();
		e.a();
		// �� Method�� ȣ���ϸ� Error �߻�
		// �� ��� ���α׷��� �����ϰų� ȯ���� �����ؾ� �Ѵ�.
	}
}
