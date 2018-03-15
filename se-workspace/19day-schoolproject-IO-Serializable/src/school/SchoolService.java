package school;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolService
{
	private ArrayList<Person> al = new ArrayList<Person>();   // ������ ������ �Ҵ�� ArrayList al ����
	private String path = "C:\\java-kosta\\test\\serial\\PersonList.obj"; // ��ü ����ȭ, ������ȭ�� �ʿ��� ���� ��ġ�� ������ String path ����
	
	public void outputList(ArrayList<Person> al) throws IOException   // ��ü ����ȭ �޼���
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.path));   // ��ü ����ȭ/������ȭ�� �ʿ��� ���� ��ġ�� ������ String path ������ ��ü ���� ����
		oos.writeObject(al);   // ������ ��ü ���Ͽ� ������ ������ ����
		oos.close();   // ObjectOuputStream�� �ӽ� ����� �����͸� �����ϰ� ���õ� �ڿ��� �ݳ�
	} 
	
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

		try 
		{
			al.add(p);   // ������ ������ ArrayList al ������ �߰�
			outputList(al);   // ������ ������ �߰��� ArrayList al ������ ����ȭ�Ͽ� ��ü ���Ͽ� ����
		}
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
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
	
		try 
		{
			al.set(index, p);   // Person p�� ��ȭ ��ȣ�� �����ϴ� ������ ������ ArrayList al �������� ����
			outputList(al);   // ������ ������ ������ ArrayList al ������ ����ȭ�Ͽ� ��ü ���Ͽ� ����
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}

	public void deletePersonByTel(String delTel) throws PersonNotFoundException   // ������ ���� ���� �޼���, delTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!"�� ȣ���ϴ� ������ ����
	{
		int index = findIndexByTel(delTel);   // delTel�� �����ϴ� ������ ���� ����� ��ȣ�� index�� �Ҵ�
		
		if(index == -1)   // �Է¹��� ��ȭ ��ȣ�� �������� ������
		{
			throw new PersonNotFoundException(delTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!");    // ��ȭ ��ȣ�� �������� ������ ���� ���ܸ� �߻�
		}
		
		try
		{
			al.remove(index);   // ������ ������ ArrayList al �������� ����
			outputList(al);   // ������ ������ ������ ArrayList al ������ ����ȭ�Ͽ� ��ü ���Ͽ� ����
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		}
	}
	
	public void printAll() throws IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.path));   // ��ü ����ȭ/������ȭ�� �ʿ��� ���� ��ġ�� ������ String path ������ ��ü ������ ���� �غ� ��
		
		@SuppressWarnings("unchecked")
		ArrayList<Person> al = (ArrayList<Person>) ois.readObject();   // ��ü ����ȭ/������ȭ�� �ʿ��� ���� ��ġ�� ������ String path ������ ��ü ������ �о�  ArrayList<Person> al�� �Ҵ�
		
		Iterator<Person> it = al.iterator();   // Collection�� ������ �ݺ��ؼ� �������ִ� Iterator �������̽��� Person ��ü�� Generic
		                                              // ArrayList al ������ iterator() �޼��带 Overriding�Ͽ� Iterator it�� �Ҵ�

		while(it.hasNext())   // al ���� �ȿ� ������ ������ �����ϸ�
		{
			System.out.println(it.next());    // ���ʴ�� �����Ͽ� ���
		}
		
		ois.close();   // ObjectIuputStream�� �ӽ� ����� �����͸� �����ϰ� ���õ� �ڿ��� �ݳ�
	}
}