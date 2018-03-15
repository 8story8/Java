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
	객체 역직렬화하여 아이유 판교를 출력
	*/
	public static void main(String[] args) 
	{
		try 
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\java-kosta\\test\\serial\\person.obj"));
			
			Person p = (Person) ois.readObject();
			System.out.println(p.getName() + " " + p.getAddress() + " " + p.getPassword());   // password는 null이 출력
																													   // transient가 명시되어 직렬화되지 않음
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
