package step2;

import java.util.ArrayList;

public class TestList2 {
	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		
		al1.add(new Person("�����", 30));
		
		// al1�� ù ��° ����� ���̸� ���
		// Object Ÿ������ ��ȯ�ǹǷ� Object Casting�ؾ� getAge();�� ȣ���� �� �ִ�.
		Person p = (Person) al1.get(0);
		System.out.println(p.getAge());
		
		System.out.println("********************");
		
		al1.add(new Person("������", 26));
		al1.add(new Person("�輭��", 24));
		
		// for���� �̿��ؼ� al1�� name�� ���
		for(int i = 0; i < al1.size(); i++){
			// System.out.println(((Person) al1.get(i)).getAge());
			// �� ������ Ǯ� ���ٸ�
			Person temp = (Person) al1.get(i);
			System.out.println(temp.getName());
		}
		
		System.out.println("********************");
		
		// �� �ڵ带 Generic�� �����ϸ� �Ʒ��� ����.
		ArrayList<Person> al2 = new ArrayList<Person>();

		al2.add(new Person("������", 24));
		al2.add(new Person("�����", 30));
		
		// ù ��° ����� �̸��� ��ȯ�޾� ���
		// Generic�� ���������Ƿ� ������ ĳ���� ������ �ʿ� ����.
		System.out.println(al2.get(0).getName());
	
		System.out.println("********************");
		
		al2.add(new Person("������", 32));
		
		// for���� �̿��� 30�� �̻� Person�� name�� ���
		for(int i = 0; i < al2.size(); i++){
			if(al2.get(i).getAge() >= 30){
				System.out.println(al2.get(i).getName());
			}
		}
	}
}
