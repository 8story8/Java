package step2;

import java.util.Scanner;

public class TestRefArray1 {

	public static void main(String[] args) {
		
		Person[] pa = {new Person("������", 23), new Person("�ϵ���", 32), new Person("���켺", 30)};
		
		for(int i = 0; i < pa.length; i++)
		{
			if(pa[i].getAge() > 25)
			{
				System.out.println(pa[i].getName() + " " + pa[i].getAge());
			}
		}
	}
}
