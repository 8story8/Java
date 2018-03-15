package inner;

/*
Inner Ŭ����(or Nested Ŭ����)�� ����ϴ� ������
Outer Ŭ������ private ����� ���� ������ ����ϱ� ���ؼ��̴�.
(private ����� �ٸ� Ŭ���������� ���� �Ұ������� Inner Ŭ������ ���ܷ� �Ѵ�.)
ref) Inner Ŭ���� ������ �� Ŭ���� ���� : Outer$Inner.class
*/

class Outer
{
	private String password;   // private���� ���������Ƿ� �ٸ� Ŭ���������� ���� �Ұ�
	
	Outer(String password)
	{
		this.password = password;
	}
	
	class Inner
	{
		public void test()
		{
			// Outer Ŭ������ private ����� ���� ������ ��� ����
			System.out.println(password);
		}
	}
}

public class TestOuter
{
	public static void main(String[] args) 
	{
		Outer outer = new Outer("javaking");
		// Inner Ŭ����(or Nested Ŭ����) ��ü ������ ���ؼ���,
		// Outer Ŭ���� ��ü ������ �����Ǿ�� �Ѵ�.
		Outer.Inner inner = outer.new Inner();
		inner.test();
	}
}
