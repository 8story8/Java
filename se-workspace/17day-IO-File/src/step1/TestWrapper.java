package step1;

public class TestWrapper 
{
	public static void main(String[] args) 
	{
		int i = 1;
		Object obj = i;   						  // Auto-Boxing(�ڵ����� Wrapper Class Integer ��ü�� ��ȯ)
		System.out.println(obj.getClass());   // class java.lang.Integer
		int j = (Integer) obj;					  // Auto-Unboxing(�ڵ����� Wrapper Class ���������� �⺻������ ��ȯ)
		System.out.println(j);
	}
}
