package school;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI
{
	private SchoolService service = new SchoolService();
	
	public void execute() throws DuplicateTelException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;   											// while문 flag 구분자
		String type1 = null;    											// 1. 추가   2. 수정   3. 삭제   4. 검색   5. 전체 회원 보기   6. 종료 구분자
		String type2 = null;    											// 1. 학생   2. 선생님   3. 직원 구분자
		String tel, name, address, stuId, subject, dept = null;   	// 전화 번호, 이름, 주소, 학번, 과목, 부서 입력 변수
		String upTel = null;												// 수정할 구성원의 전화 번호 입력 변수
		String upInfo = null;												// 수정할 구성원의 이름, 주소, 학번 or 과목 or 부서 입력 변수
		String upInfoPart[] = null;
		String delTel = null;   											// 삭제할 구성원의 전화 번호 입력 변수
		String findTel = null;  											// 검색할 구성원의 전화 번호 입력 변수
		Person p = null;   													// 학생, 선생님, 직원에 맞게 참조할 Person p 변수
	
		System.out.println("**********학사 관리 프로그램을 시작합니다!**********");
		
		while(flag != true)   // flag 변수의 초기값은 false이므로 무한 Loop 진입
		{
			System.out.println("1. 추가   2. 수정   3. 삭제   4. 검색   5. 전체 회원 보기   6. 종료");
			
			type1 = sc.nextLine();   // 1. 추가   2. 수정   3. 삭제   4. 검색   5. 전체 회원 보기   6. 종료 구분자 입력
			
			if(type1.equals("1"))   // 1. 추가
			{
				System.out.println("입력할 구성원의 종류를 선택하세요!");
				System.out.println("1. 학생   2. 선생님   3. 직원");
				type2 = sc.nextLine();   // 1. 학생   2. 선생님   3. 직원 구분자 입력
				
				if(type2.equals("1") || type2.equals("2") || type2.equals("3"))   // 1. 학생   2. 선생님   3. 직원 중 하나를 선택하면
				{
					System.out.println("1. 전화 번호를 입력하세요!");
					tel = sc.nextLine();   // 전화 번호 입력
					
					try
					{
						if(service.findIndexByTel(tel) != -1)   // 입력받은 전화 번호가 중복이면
						{
							throw new DuplicateTelException(tel + "번호는 중복입니다!");   // tel + "번호는 중복입니다!라는 예외를 발생시키고,
							 																	             // 이 예외를 처리하기 위해 catch문으로 전송
						}
			
					System.out.println("2. 이름을 입력하세요!");
					name = sc.nextLine();   // 이름 입력
					
					System.out.println("3. 주소를 입력하세요!");
					address = sc.nextLine();   // 주소 입력
				
					switch(type2)   // 1. 학생   2. 선생님   3. 직원 구분자에 따라서
					{
						case "1" :   // 1. 학생
							System.out.println("4. 학번을 입력하세요!");
							stuId = sc.nextLine();   // 학번 입력
							p = new Student(tel, name, address, stuId);   // Person p 변수는 Student 객체를 참조, 생성
							
							try 
							{
								service.addPerson(p);   // 생성된 Student 객체를 SchoolService service 객체의 메서드 addPerson(Person p)의 Local Variable로 전달
								System.out.println(p.toString());   // 생성된 Student 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가되고,
																		   // 이를 Person Class의 toString() 메서드를 Overriding한 Student Class의 toString() 메서드를 통해 출력
							} 
							catch (DuplicateTelException de) 
							{
								System.out.println(de.getMessage());   // 생성된 Student 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가될 때,
																				 // 입력받은 전화 번호가 중복이면 SchoolService service 객체의 메서드 addPerson(Person p)에서 전송된 p.getTel() + "번호가 존재하여 추가 불가!"가 출력
							}
							break;
						case "2" :   // 2. 선생님
							System.out.println("4. 과목을 입력하세요!");
							subject = sc.nextLine();   // 과목 입력
							p = new Teacher(tel, name, address, subject);   // Person p 변수는 Teacher 객체를 참조, 생성
							try 
							{
								service.addPerson(p);   // 생성된 Teacher 객체를 SchoolService service 객체의 메서드 addPerson(Person p)의 Local Variable로 전달
								System.out.println(p.toString());   // 생성된 Teacher 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가되고,
								                                           // 이를 Person Class의 toString() 메서드를 Overriding한 Teacher Class의 toString() 메서드를 통해 출력
							} 
							catch (DuplicateTelException de) 
							{
								System.out.println(de.getMessage());   // 생성된 Teacher 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가될 때,
								                                                 // 입력받은 전화 번호가 중복이면 SchoolService service 객체의 메서드 addPerson(Person p)에서 전송된 p.getTel() + "번호가 존재하여 추가 불가!"가 출력
							}
							break;
						case "3" :   // 3. 직원
							System.out.println("4. 부서를 입력하세요!");
							dept = sc.nextLine();   // 부서 입력
							p = new Employee(tel, name, address, dept);   // Person p 변수는 Employee 객체를 참조, 생성
							try 
							{
								service.addPerson(p);   // 생성된 Employee 객체를 SchoolService service 객체의 메서드 addPerson(Person p)의 Local Variable로 전달
								System.out.println(p.toString());   // 생성된 Employee 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가되고,
                                                                           // 이를 Person Class의 toString() 메서드를 Overriding한 Employee Class의 toString() 메서드를 통해 출력
							} 
							catch (DuplicateTelException de) 
							{
							System.out.println(de.getMessage());   // 생성된 Employee 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에 추가될 때,
                            										         // 입력받은 전화 번호가 중복이면 SchoolService service 객체의 메서드 addPerson(Person p)에서 전송된 p.getTel() + "번호가 존재하여 추가 불가!"가 출력
							}
							break;
						}
					}
					catch(DuplicateTelException de)
					{
						System.out.println(de.getMessage());   // 위에 발생시킨 예외 처리로 tel + "번호는 중복입니다! 다시 입력해주세요!를 출력
						                                                 // 그리고 무한 Loop 재진입
					}
				}
			}
			else if(type1.equals("2"))   // 2. 수정
			{
				System.out.println("수정할 구성원의 전화 번호를 입력하세요!");
				upTel = sc.nextLine();   // 수정할 구성원의 전화 번호 입력
				try 
				{
					if(service.findIndexByTel(upTel) == -1)   // 입력받은 전화 번호가 존재하지 않으면
					{
						throw new PersonNotFoundException(upTel + "번호는 존재하지 않아 수정 불가!");   // upTel + "번호는 존재하지 않아 수정 불가!"라는 예외를 발생시키고,		
																																   // 이 예외를 처리하기 위해 catch문으로 전송
					}
					
					p = service.findPersonByTel(upTel);   // 수정할 구성원의 전화 번호에 상응하는 Person 객체를 Person p 변수가 참조
					
					System.out.println("수정할 구성원의 정보를 입력하세요!");
					System.out.println("이름   주소   학번 or 과목 or 부서(구분은 띄어쓰기 3번)");
					
					upInfo = sc.nextLine();   // 이름, 주소, 학번 or 과목 or 부서 입력
					upInfoPart = upInfo.split("   ");   // 띄어쓰기 3번으로 구분
					
					if(p instanceof Student)   // Person p 변수가 Student 객체 타입이면
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Student) p).setStuId(upInfoPart[2]);
					}
					else if(p instanceof Teacher)   // Person p 변수가 Teacher 객체 타입이면
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Teacher) p).setSubject(upInfoPart[2]);
					}
					else if(p instanceof Employee)   // Person p 변수가 Employee 객체 타입이면
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Employee) p).setDept(upInfoPart[2]);
					}
					
					service.updatePerson(p);   // Student || Teacher || Employee로 Object Down Casting되어 수정된 Person 객체를 SchoolService service 객체의 메서드 updatePerson(Person p)의 Local Variable로 전달
					System.out.println(p.toString());   // Student || Teacher || Employee로 Object Down Casting되어 수정된 Person 객체가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 수정되고,
					   										   // 이를 Person Class의 toString() 메서드를 Overriding한 Student || Teacher || Employee Class의 toString() 메서드를 통해 출력
				}
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // 수정할 구성원의 전화 번호를 통해 해당 구성원의 정보가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 수정될 때,
			                                                         // 수정할 구성원의 전화 번호가 존재하지 않으면 SchoolService service 객체의 메서드 service.updatePerson(Person p)에서 전송된 upTel + "번호는 존재하지 않아 수정 불가!"가 출력
				}
			}
			else if(type1.equals("3"))   // 3. 삭제
			{
				System.out.println("삭제할 구성원의 전화 번호를 입력하세요!");
				delTel = sc.nextLine();   // 삭제할 구성원의 전화 번호 입력
				try 
				{
					service.deletePersonByTel(delTel);   // 삭제할 구성원의 전화 번호를 SchoolService service 객체의 메서드 deletePersonByTel(delTel)의 Local Variable로 전달
					System.out.println(p.toString());   // 삭제할 구성원의 전화 번호를 통해 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 해당 구성원의 정보가 삭제되고,
                    										   // 이를 Person Class의 toString() 메서드를 Overriding한 Student, Teacher, Employee Class의 toString() 메서드를 통해 출력
					System.out.println(delTel + " Delete OK");   // 삭제한 구성원의 전화 번호를 통한 해당 구성원의 정보 삭제 내역 출력 
				} 
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // 삭제할 구성원의 전화 번호를 통해 해당 구성원의 정보가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 삭제될 때,
			                                                         // 삭제할 구성원의 전화 번호가 존재하지 않으면 SchoolService service 객체의 메서드 deletePersonByTel(String delTel)에서 전송된 delTel + "번호가 존재하지 않아 삭제 불가!"가 출력
				}
			}
			else if(type1.equals("4"))   // 4. 검색
			{
				System.out.println("검색할 구성원의 전화 번호를 입력하세요!");
				findTel = sc.nextLine();   // 검색할 구성원의 전화 번호 입력
				try 
				{
					p = service.findPersonByTel(findTel);   // 검색할 구성원의 전화 번호를 SchoolService service 객체의 메서드 findPersonByTel(findTel)의 Local Variable로 전달
					System.out.println(p);   // 검색할 구성원의 전화 번호를 통해 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 해당 구성원의 정보가 검색되고,
					                              // 이를 Person Class의 toString() 메서드를 Overriding한 Student, Teacher, Employee Class의 toString() 메서드를 통해 출력
				} 
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // 검색할 구성원의 전화 번호를 통해 해당 구성원의 정보가 SchoolService service 객체의 Instance Variable인 ArrayList al 변수에서 검색될 때,
                                                                     // 검색할 구성원의 전화 번호가 존재하지 않으면 SchoolService service 객체의 메서드 findPersonByTel(findTel)에서 전송된 findTel + "번호가 존재하지 않아 조회 불가!"가 출력
				}
			}
			else if(type1.equals("5"))   // 5. 전체 회원 보기
			{
				System.out.println("**********전체 구성원 보기**********");
				
				try 
				{
					service.printAll();   // SchoolService service 객체의 메서드 printAll()을 통해 전체 회원 정보 출력
				} 
				catch (ClassNotFoundException | IOException e) 
				{
					e.printStackTrace();
				}   
			}
			else if(type1.equals("6"))   // 6. 종료
			{
				System.out.println("**********학사 관리 프로그램을 종료합니다!**********");
				flag = true;   // flag를 true로 할당한 뒤 무한 Loop 탈출
			}
			else   // 잘못된 입력값이면
			{
				System.out.println("잘못된 입력값입니다!");
			}
		}
	}
}
