package step4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import step3.Person;

public class TestSerializable2 
{
	/*
	FileInputStream < ObjectInputStream
							readObject() : Object
	��ü ������ȭ�Ͽ� ������ �Ǳ��� ���
	*/
	public static void main(String[] args) 
	{
		try 
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\java-kosta\\test\\serial\\person.obj"));
			
			Person p = (Person) ois.readObject();
			System.out.println(p.getName() + " " + p.getAddress() + " " + p.getPassword());   // password�� null�� ���
																													   // transient�� ��õǾ� ����ȭ���� ����
			ois.close();
		} 
		catch (FileNotFoundException fe) 
		{
			fe.printStackTrace();
		} 
		catch (IOException ie) 
		{
			ie.printStackTrace();
		} 
		catch (ClassNotFoundException ce) 
		{
			ce.printStackTrace();
		}
	}
}
