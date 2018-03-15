package step2;

import java.util.HashMap;

public class TestMap1 
{
	public static void main(String[] args) 
	{
		HashMap hm = new HashMap();
		
		// key, value ������ ����
		hm.put("1", new Person("������", 24));
		hm.put("2", new Person("�����", 30));
		
		// key�� 2�� ����� �̸��� ��ȯ�޾� ���
		//Generic�� �������� �ʾ����Ƿ� �ֻ��� Ŭ���� Ÿ���� Object������ ��ȯ
		// getName()�� ȣ���ϱ� ���ؼ��� Object Casting�� �ʿ��ϴ�.
		Person p = (Person)hm.get("2");
		System.out.println(p.getName());
		
		System.out.println("********************");
		
		// Generic ���� Map
		HashMap<String, Person> ghm = new HashMap<String, Person>();
		
		// "a" key�� �̸��� ��ȯ�޾� ���
		ghm.put("a", new Person("�⼺��", 30));
		System.out.println(ghm.get("a"));
		
		System.out.println("********************");
		
		// ������ "a" key�� �̸��� ��ȯ�޾� ���
		ghm.put("a", new Person("�����", 26));
		System.out.println(ghm.get("a"));
		
		System.out.println("********************");
		
		// "bb" key�� ���� ���� �ľ�
		ghm.put("b", new Person("�޽�", 30));	
		boolean flag = ghm.containsKey("bb");
		System.out.println("key�� ���� ���� : " + flag);
		
		System.out.println("********************");
		
		// "a" key ��Ҹ� ����
		System.out.println(ghm.remove("a") + " ����");
		System.out.println(ghm);
	}
}
