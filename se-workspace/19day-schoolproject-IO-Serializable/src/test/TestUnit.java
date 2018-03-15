package test;

import java.io.IOException;

import school.DuplicateTelException;
import school.Employee;
import school.Person;
import school.PersonNotFoundException;
import school.Student;
import school.Teacher;
import school.SchoolService;

public class TestUnit 
{ 
	public static void main(String[] args) 
	{
		SchoolService service = new SchoolService();
		
		try 
		{
			service.addPerson(new Student("011", "��ƶ�", "�Ǳ�", "14"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Teacher("016", "����ȣ", "����", "����"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Employee("017", "�̰��", "�Ǳ�", "�ѹ�"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Teacher("016", "�߽ż�", "�Ǳ�", "����"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.printAll();
		} 
		catch 
		(ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		} 
		
		System.out.println("********************step1 : add �Ϸ�********************");
		
		try 
		{
			Person rp = service.findPersonByTel("017");
			System.out.println(rp);
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		
		try 
		{
			Person rp = service.findPersonByTel("010");
			System.out.println(rp);
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		System.out.println("********************step2 : find �Ϸ�********************"); 
		
		try 
		{
			service.updatePerson(new Student("016", "�̴�ȣ", "�Ǳ�", "13"));
			System.out.println(service.findPersonByTel("016"));
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		
		try 
		{
			service.updatePerson(new Student("010", "������", "�Ǳ�", "13"));
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		System.out.println("********************step3 : update �Ϸ�********************");
		
		try 
		{
			service.deletePersonByTel("016");
			System.out.println("���� OK");
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		
		try 
		{
			service.deletePersonByTel("010");
			System.out.println("���� OK");
		}	
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		try 
		{
			service.printAll();
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();
		}  
		
		System.out.println("********************step4 : delete �Ϸ�********************");
	}
}


/*
016��ȣ�� �����Ͽ� �߰� �Ұ�!
tel = 011, name = ��ƶ�, address = �Ǳ�, stuId = 14
tel = 016, name = ����ȣ, address = ����, subject = ����
tel = 017, name = �̰��, address = �Ǳ�, dept = �ѹ�
********************step1 : add �Ϸ�********************
tel = 017, name = �̰��, address = �Ǳ�, dept = �ѹ�
010��ȣ�� �������� �ʾ� ��ȸ �Ұ�!
********************step2 : find �Ϸ�********************
tel = 016, name = �̴�ȣ, address = �Ǳ�, stuId = 13
010��ȣ�� �����Ͽ� ���� �Ұ�!
********************step3 : update �Ϸ�********************
���� OK
010��ȣ�� �������� �ʾ� ���� �Ұ�!
tel = 011, name = ��ƶ�, address = �Ǳ�, stuId = 14
tel = 017, name = �̰��, address = �Ǳ�, dept = �ѹ�
********************step4 : delete �Ϸ�*********************
*/
  
 