package step2;

import java.util.ArrayList;

public class TestList1 {
	public static void main(String[] args) 
	{
		String name = "������";
		ArrayList al = new ArrayList();
		
		al.add(name);
		
		// ù ��° ��Ҹ� ��ȯ�޴´�.
		// Generic�� �������� ������ 
		// �ֻ��� Object Ŭ���� Ÿ������ ����ǰ� ��ȯ�ǹǷ�. 
		// String Ŭ������ �޼����� length�� ȣ���ϱ� ���ؼ��� 
		// Object Casting ������ �ʿ��ϴ�.
		String str = (String) al.get(0);
		System.out.println(str.length());
		
		al.add("������");
		System.out.println(al);
		
		al.add("�����");
		al.add("������");
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i));
		}
		
		System.out.println("0�� �ε��� ��� ���� : " + al.remove(0));
		System.out.println(al);
		
		System.out.println("���� : " + al.remove("������"));
		System.out.println(al);
		
		al.clear();
		System.out.println(al);
	}
}
