package step1;

public class TestWrapper 
{
	public static void main(String[] args) 
	{
		int i = 1;
		Object obj = i;   						  // Auto-Boxing(자동으로 Wrapper Class Integer 객체로 변환)
		System.out.println(obj.getClass());   // class java.lang.Integer
		int j = (Integer) obj;					  // Auto-Unboxing(자동으로 Wrapper Class 참조형에서 기본형으로 변환)
		System.out.println(j);
	}
}
