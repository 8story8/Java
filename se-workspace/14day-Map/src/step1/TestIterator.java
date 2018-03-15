package step1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class TestIterator 
{
	public static void main(String[] args) 
	{
		// ArrayList<String> al = new ArrayList<String>();
		Collection<String> c1 = new ArrayList<String>();
		
		c1.add("����");
		c1.add("¥���");
		c1.add("«��");
		
		Iterator<String> it1 = c1.iterator();
		
		while(it1.hasNext())   // ���� ��Ұ� �����ϸ� true, �������� ������ false
		{
			System.out.println(it1.next());   // ���� ��Ҹ� ��ȯ
		}
		
		System.out.println("********************");
		
		Collection<String> c2 = new TreeSet<String>();
		c2.add("��������");
		c2.add("��������");
		c2.add("��������");
		
		Iterator<String> it2 = c2.iterator();
		while(it2.hasNext())
		{
			System.out.println(it2.next());
		}
		/*
		ArrayList, TreeSet�� ���� Collection �������̽��� ���� ����ü��
		Collection �������̽��� iterator() �߻� �޼��带 �����߱� ������,
		iterator() �޼��� ȣ�� �� ��ȯ�Ǵ� Iterator�� Set�̵� List�� �������
		ǥ��ȭ�� ������� ��ҵ��� �ݺ� ������ �� �ִ�.
		*/
	}
}
