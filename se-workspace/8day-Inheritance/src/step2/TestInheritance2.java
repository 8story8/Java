package step2;

class Animal
{
	private int age = 1;

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}

class Person extends Animal   // ��� ���踦 ǥ��
{
	public void study()
	{
		System.out.println("�����ϴ�.");
	}
}

public class TestInheritance2 {
	public static void main(String[] args) {
		Person p = new Person();
		// System.out.println(p.age);
		// �� �ڵ�� age�� private�̹Ƿ� ��ӹ޴��� ���� ������ �Ұ����ؼ� Error
		// �Ʒ�ó�� getter/setter�� ���� ����
		System.out.println(p.getAge());
	
	}

}
