package step8;

import step4.Animal;
import step4.Person;

// java.lang.Object�� ��� Java Ŭ������ super Ŭ����(�θ� Ŭ����)
// import java.lang.*;

public class TestObject   // extends Object 
{
	/*
	public TestObject()
	{
		super();
	}
	*/
	
	public static void main(String[] args) {
		Object a = new Animal();
		Object a2 = new Person();
		// ���� ���� ��� Java ��ü�� �ֻ��� �θ� Ŭ������ Object Ÿ������ ���� ����
		// �׷��� Object Casting�� �ʿ��� �� �ִ�.
		((Animal) a).play();
		// �ֻ��� Ŭ������ Object Ÿ������ �迭�� �����ϸ� ��� ��ü�� �迭�� ��ҷ� ���� ����
		Object []obj = {new Animal(), new Person(), new Car()};
		for(int i = 0; i < obj.length; i++)
		{
			System.out.println(obj[i].getClass().getName());
		}
	}
}

class Car
{
	
}
