package step4;

public class TestString {
	// ���ڿ� �� ���� ����
	
	public static void main(String[] args) {
		String name1 = "������,����,�����";
		// String class�� �޼��带 �̿���
		// Ư�� �����ڸ� �߽����� ���ڿ� ������ ������ �迭 ��ҷ� ������ ���
		String na[] = name1.split(",");
		
		for(int i = 0; i < na.length; i++)
		{
			System.out.println(na[i]);
		}
		
		System.out.println("********************");
		
		// java���� ���ڿ��� �����ϴ� ����� �پ��ϴ�.
		String str1 = "����";
		String str2 = new String("����");
		System.out.println(str1);
		System.out.println(str2);
		
		StringBuilder sb = new StringBuilder("����");
		System.out.println(sb);									// ����
		
		System.out.println(str1 == str2);						// false
		System.out.println(str1 == sb.toString());			// false
		
		// ���ڿ� �񱳴� == �������� �ϴ� ���� �ƴ϶�
		// String class�� equals �޼��带 �̿�
		System.out.println(str1.equals(str2));					// true
		System.out.println(str1.equals(sb.toString()));		// true
		
	}
}
