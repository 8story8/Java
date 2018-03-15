// Package �����Ͽ� step1 ���丮 �Ʒ��� TestPerson class ����

package step1;

/*
TestPerson class�� Person class�� �̿���
Object �����ϰ� �Ӽ��� Data�� �Ҵ��غ���
Person ��ü�� ����� �����غ��� ����
Person class : Person ��ü�� �����ϱ� ���� Ʋ
TestPerson class : Main Method�� ����Ͽ� Program�� ������ �����ϰ� �ϰ�
�ٸ� Class�� �̿��� ��ü ���� �� ��� �׽�Ʈ
 */

public class TestPerson {
	/*
	Main Method�� Java Program�� ������
	 */
	
	public static void main(String[] args) {
		    /* 
		    Person class�� �̿��� Object ����
		    Person : Data Type(Reference Data Type)
		    p : ������(Reference Variable)
		    = �Ҵ� or ����
		    new : Object ������ ����ϴ� Java Keyword
		    Person() : ������(Constructor)
		     */
		
			Person p = new Person();
			p.name = "������";   // ����(�Ӽ�)�� �̸� ����
			System.out.println(p.name);   // ������ �̸� ���
			
			// Object�� �ѹ� �� ����
			Person p2 = new Person();
			
			// p2 ��ü�� name�� ����ϸ� �Ҵ�
			p2.name = "�����";
			System.out.println(p2.name);
			// p2 ��ü�� name�� ���
			
			// p, p2 ��ü�� study Method�� ȣ��
			p.study();
			p2.study();
	}
}
