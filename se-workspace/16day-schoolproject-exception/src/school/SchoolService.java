package school;

import java.util.ArrayList;
import java.util.Iterator;

public class SchoolService
{
	private ArrayList<Person> al = new ArrayList<Person>();   // ������ ������ �Ҵ�� ArrayList al ����

	public int findIndexByTel(String tel)   // ������ ���� ����� ��ȣ return �޼���
	{
		int index = -1;
		
		for(int i = 0; i < al.size(); i++)
		{
			if(tel.equals(al.get(i).getTel()))   // �Էµ� ��ȭ ��ȣ�� �����ϴ� ������ ������ ��ȭ ��ȣ�� ��ġ�ϸ�
			{
				index = i;   // �ش� ����� ��ȣ�� index ������ �Ҵ��ϰ�,
				break;   // break�� ���� for���� Ż��
			}	
		}
		
		return index;  // tel�� �����ϴ� �������� ������ ������ -1, ������ tel�� �����ϴ� �������� ���� ����� ��ȣ�� return
	}
	
	public void addPerson(Person p) throws DuplicateTelException   // ������ ���� �߰� �޼���, p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!"�� ȣ���ϴ� ������ ����
	{
		if(findIndexByTel(p.getTel()) != -1)   // �Է¹��� ��ȭ ��ȣ�� �ߺ��̸�
		{
			throw new DuplicateTelException(p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!");  // ��ȭ ��ȣ �ߺ��� ���� ���ܸ� �߻�
		}
		
		al.add(p);   // ������ ������ ArrayList al ������ �߰�
	}

	public Person findPersonByTel(String findTel) throws PersonNotFoundException   // ������ ���� �˻� �޼���, findTel + "��ȣ�� �������� �ʾ� ��ȸ �Ұ�!"�� ȣ���ϴ� ������ ����
	{
		int index = findIndexByTel(findTel);   // findTel�� �����ϴ� ������ ���� ����� ��ȣ�� index�� �Ҵ�
		
		if(index == -1)   // �Է¹��� ��ȭ ��ȣ�� �������� ������
		{
			throw new PersonNotFoundException(findTel + "��ȣ�� �������� �ʾ� ��ȸ �Ұ�!");   // ��ȭ ��ȣ�� �������� ������ ���� ���ܸ� �߻�
		}
		
		return al.get(index);   // findTel�� �����ϴ� �������� ������ ������ ���� ���� ó���� ����, ������ findTel�� �����ϴ� �������� ���� ��ü�� return
	}

	public void updatePerson(Person p) throws PersonNotFoundException   // ������ ���� ���� �޼���, p.getTel() + "��ȣ�� �������� �ʾ� ���� �Ұ�!"�� ȣ���ϴ� ������ ����
	{
		int index = findIndexByTel(p.getTel());   // Person p�� ��ȭ ��ȣ�� �����ϴ� ������ ���� ����� ��ȣ�� index�� �Ҵ�
		
		if(index == -1)    // �Է¹��� ��ȭ ��ȣ�� �������� ������
		{
			throw new PersonNotFoundException(p.getTel() + "��ȣ�� �������� �ʾ� ���� �Ұ�!");
		}
		
		al.set(index, p);   // Person p�� ��ȭ ��ȣ�� �����ϴ� ������ ������ ArrayList al �������� ����
	}

	public void deletePersonByTel(String delTel) throws PersonNotFoundException   // ������ ���� ���� �޼���, delTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!"�� ȣ���ϴ� ������ ����
	{
		int index = findIndexByTel(delTel);   // delTel�� �����ϴ� ������ ���� ����� ��ȣ�� index�� �Ҵ�
		
		if(index == -1)   // �Է¹��� ��ȭ ��ȣ�� �������� ������
		{
			throw new PersonNotFoundException(delTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!");    // ��ȭ ��ȣ�� �������� ������ ���� ���ܸ� �߻�
		}
		
		al.remove(index);   // ������ ������ ArrayList al �������� ����
	}
	
	public void printAll() 
	{
		Iterator<Person> it = al.iterator();   // Collection�� ������ �ݺ��ؼ� �������ִ� Iterator �������̽��� Person ��ü�� Generic
													  // ArrayList al ������ iterator() �޼��带 Overriding�Ͽ� Iterator it�� �Ҵ�
		
		while(it.hasNext())   // al ���� �ȿ� ������ ������ �����ϸ�
		{
			System.out.println(it.next());   // ���ʴ�� �����Ͽ� ���
		}
	}
}