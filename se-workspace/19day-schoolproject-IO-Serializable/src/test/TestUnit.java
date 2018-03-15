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
			service.addPerson(new Student("011", "고아라", "판교", "14"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Teacher("016", "박찬호", "강남", "국어"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Employee("017", "이경규", "판교", "총무"));
		} 
		catch (DuplicateTelException de) 
		{
			System.out.println(de.getMessage());
		}
		
		try 
		{
			service.addPerson(new Teacher("016", "추신수", "판교", "수학"));
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
		
		System.out.println("********************step1 : add 완료********************");
		
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
		System.out.println("********************step2 : find 완료********************"); 
		
		try 
		{
			service.updatePerson(new Student("016", "이대호", "판교", "13"));
			System.out.println(service.findPersonByTel("016"));
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		
		try 
		{
			service.updatePerson(new Student("010", "구혜선", "판교", "13"));
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		System.out.println("********************step3 : update 완료********************");
		
		try 
		{
			service.deletePersonByTel("016");
			System.out.println("삭제 OK");
		} 
		catch (PersonNotFoundException pe) 
		{
			System.out.println(pe.getMessage());
		}
		
		try 
		{
			service.deletePersonByTel("010");
			System.out.println("삭제 OK");
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
		
		System.out.println("********************step4 : delete 완료********************");
	}
}


/*
016번호가 존재하여 추가 불가!
tel = 011, name = 고아라, address = 판교, stuId = 14
tel = 016, name = 박찬호, address = 강남, subject = 국어
tel = 017, name = 이경규, address = 판교, dept = 총무
********************step1 : add 완료********************
tel = 017, name = 이경규, address = 판교, dept = 총무
010번호가 존재하지 않아 조회 불가!
********************step2 : find 완료********************
tel = 016, name = 이대호, address = 판교, stuId = 13
010번호가 존재하여 수정 불가!
********************step3 : update 완료********************
삭제 OK
010번호가 존재하지 않아 삭제 불가!
tel = 011, name = 고아라, address = 판교, stuId = 14
tel = 017, name = 이경규, address = 판교, dept = 총무
********************step4 : delete 완료*********************
*/
  
 