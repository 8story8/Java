package school;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI
{
	private SchoolService service = new SchoolService();
	
	public void execute() throws DuplicateTelException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;   											// while�� flag ������
		String type1 = null;    											// 1. �߰�   2. ����   3. ����   4. �˻�   5. ��ü ȸ�� ����   6. ���� ������
		String type2 = null;    											// 1. �л�   2. ������   3. ���� ������
		String tel, name, address, stuId, subject, dept = null;   	// ��ȭ ��ȣ, �̸�, �ּ�, �й�, ����, �μ� �Է� ����
		String upTel = null;												// ������ �������� ��ȭ ��ȣ �Է� ����
		String upInfo = null;												// ������ �������� �̸�, �ּ�, �й� or ���� or �μ� �Է� ����
		String upInfoPart[] = null;
		String delTel = null;   											// ������ �������� ��ȭ ��ȣ �Է� ����
		String findTel = null;  											// �˻��� �������� ��ȭ ��ȣ �Է� ����
		Person p = null;   													// �л�, ������, ������ �°� ������ Person p ����
	
		System.out.println("**********�л� ���� ���α׷��� �����մϴ�!**********");
		
		while(flag != true)   // flag ������ �ʱⰪ�� false�̹Ƿ� ���� Loop ����
		{
			System.out.println("1. �߰�   2. ����   3. ����   4. �˻�   5. ��ü ȸ�� ����   6. ����");
			
			type1 = sc.nextLine();   // 1. �߰�   2. ����   3. ����   4. �˻�   5. ��ü ȸ�� ����   6. ���� ������ �Է�
			
			if(type1.equals("1"))   // 1. �߰�
			{
				System.out.println("�Է��� �������� ������ �����ϼ���!");
				System.out.println("1. �л�   2. ������   3. ����");
				type2 = sc.nextLine();   // 1. �л�   2. ������   3. ���� ������ �Է�
				
				if(type2.equals("1") || type2.equals("2") || type2.equals("3"))   // 1. �л�   2. ������   3. ���� �� �ϳ��� �����ϸ�
				{
					System.out.println("1. ��ȭ ��ȣ�� �Է��ϼ���!");
					tel = sc.nextLine();   // ��ȭ ��ȣ �Է�
					
					try
					{
						if(service.findIndexByTel(tel) != -1)   // �Է¹��� ��ȭ ��ȣ�� �ߺ��̸�
						{
							throw new DuplicateTelException(tel + "��ȣ�� �ߺ��Դϴ�!");   // tel + "��ȣ�� �ߺ��Դϴ�!��� ���ܸ� �߻���Ű��,
							 																	             // �� ���ܸ� ó���ϱ� ���� catch������ ����
						}
			
					System.out.println("2. �̸��� �Է��ϼ���!");
					name = sc.nextLine();   // �̸� �Է�
					
					System.out.println("3. �ּҸ� �Է��ϼ���!");
					address = sc.nextLine();   // �ּ� �Է�
				
					switch(type2)   // 1. �л�   2. ������   3. ���� �����ڿ� ����
					{
						case "1" :   // 1. �л�
							System.out.println("4. �й��� �Է��ϼ���!");
							stuId = sc.nextLine();   // �й� �Է�
							p = new Student(tel, name, address, stuId);   // Person p ������ Student ��ü�� ����, ����
							
							try 
							{
								service.addPerson(p);   // ������ Student ��ü�� SchoolService service ��ü�� �޼��� addPerson(Person p)�� Local Variable�� ����
								System.out.println(p.toString());   // ������ Student ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��ǰ�,
																		   // �̸� Person Class�� toString() �޼��带 Overriding�� Student Class�� toString() �޼��带 ���� ���
							} 
							catch (DuplicateTelException de) 
							{
								System.out.println(de.getMessage());   // ������ Student ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��� ��,
																				 // �Է¹��� ��ȭ ��ȣ�� �ߺ��̸� SchoolService service ��ü�� �޼��� addPerson(Person p)���� ���۵� p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!"�� ���
							}
							break;
						case "2" :   // 2. ������
							System.out.println("4. ������ �Է��ϼ���!");
							subject = sc.nextLine();   // ���� �Է�
							p = new Teacher(tel, name, address, subject);   // Person p ������ Teacher ��ü�� ����, ����
							try 
							{
								service.addPerson(p);   // ������ Teacher ��ü�� SchoolService service ��ü�� �޼��� addPerson(Person p)�� Local Variable�� ����
								System.out.println(p.toString());   // ������ Teacher ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��ǰ�,
								                                           // �̸� Person Class�� toString() �޼��带 Overriding�� Teacher Class�� toString() �޼��带 ���� ���
							} 
							catch (DuplicateTelException de) 
							{
								System.out.println(de.getMessage());   // ������ Teacher ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��� ��,
								                                                 // �Է¹��� ��ȭ ��ȣ�� �ߺ��̸� SchoolService service ��ü�� �޼��� addPerson(Person p)���� ���۵� p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!"�� ���
							}
							break;
						case "3" :   // 3. ����
							System.out.println("4. �μ��� �Է��ϼ���!");
							dept = sc.nextLine();   // �μ� �Է�
							p = new Employee(tel, name, address, dept);   // Person p ������ Employee ��ü�� ����, ����
							try 
							{
								service.addPerson(p);   // ������ Employee ��ü�� SchoolService service ��ü�� �޼��� addPerson(Person p)�� Local Variable�� ����
								System.out.println(p.toString());   // ������ Employee ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��ǰ�,
                                                                           // �̸� Person Class�� toString() �޼��带 Overriding�� Employee Class�� toString() �޼��带 ���� ���
							} 
							catch (DuplicateTelException de) 
							{
							System.out.println(de.getMessage());   // ������ Employee ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al ������ �߰��� ��,
                            										         // �Է¹��� ��ȭ ��ȣ�� �ߺ��̸� SchoolService service ��ü�� �޼��� addPerson(Person p)���� ���۵� p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!"�� ���
							}
							break;
						}
					}
					catch(DuplicateTelException de)
					{
						System.out.println(de.getMessage());   // ���� �߻���Ų ���� ó���� tel + "��ȣ�� �ߺ��Դϴ�! �ٽ� �Է����ּ���!�� ���
						                                                 // �׸��� ���� Loop ������
					}
				}
			}
			else if(type1.equals("2"))   // 2. ����
			{
				System.out.println("������ �������� ��ȭ ��ȣ�� �Է��ϼ���!");
				upTel = sc.nextLine();   // ������ �������� ��ȭ ��ȣ �Է�
				try 
				{
					if(service.findIndexByTel(upTel) == -1)   // �Է¹��� ��ȭ ��ȣ�� �������� ������
					{
						throw new PersonNotFoundException(upTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!");   // upTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!"��� ���ܸ� �߻���Ű��,		
																																   // �� ���ܸ� ó���ϱ� ���� catch������ ����
					}
					
					p = service.findPersonByTel(upTel);   // ������ �������� ��ȭ ��ȣ�� �����ϴ� Person ��ü�� Person p ������ ����
					
					System.out.println("������ �������� ������ �Է��ϼ���!");
					System.out.println("�̸�   �ּ�   �й� or ���� or �μ�(������ ���� 3��)");
					
					upInfo = sc.nextLine();   // �̸�, �ּ�, �й� or ���� or �μ� �Է�
					upInfoPart = upInfo.split("   ");   // ���� 3������ ����
					
					if(p instanceof Student)   // Person p ������ Student ��ü Ÿ���̸�
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Student) p).setStuId(upInfoPart[2]);
					}
					else if(p instanceof Teacher)   // Person p ������ Teacher ��ü Ÿ���̸�
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Teacher) p).setSubject(upInfoPart[2]);
					}
					else if(p instanceof Employee)   // Person p ������ Employee ��ü Ÿ���̸�
					{
						p.setName(upInfoPart[0]);
						p.setAddress(upInfoPart[1]);
						((Employee) p).setDept(upInfoPart[2]);
					}
					
					service.updatePerson(p);   // Student || Teacher || Employee�� Object Down Casting�Ǿ� ������ Person ��ü�� SchoolService service ��ü�� �޼��� updatePerson(Person p)�� Local Variable�� ����
					System.out.println(p.toString());   // Student || Teacher || Employee�� Object Down Casting�Ǿ� ������ Person ��ü�� SchoolService service ��ü�� Instance Variable�� ArrayList al �������� �����ǰ�,
					   										   // �̸� Person Class�� toString() �޼��带 Overriding�� Student || Teacher || Employee Class�� toString() �޼��带 ���� ���
				}
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // ������ �������� ��ȭ ��ȣ�� ���� �ش� �������� ������ SchoolService service ��ü�� Instance Variable�� ArrayList al �������� ������ ��,
			                                                         // ������ �������� ��ȭ ��ȣ�� �������� ������ SchoolService service ��ü�� �޼��� service.updatePerson(Person p)���� ���۵� upTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!"�� ���
				}
			}
			else if(type1.equals("3"))   // 3. ����
			{
				System.out.println("������ �������� ��ȭ ��ȣ�� �Է��ϼ���!");
				delTel = sc.nextLine();   // ������ �������� ��ȭ ��ȣ �Է�
				try 
				{
					service.deletePersonByTel(delTel);   // ������ �������� ��ȭ ��ȣ�� SchoolService service ��ü�� �޼��� deletePersonByTel(delTel)�� Local Variable�� ����
					System.out.println(p.toString());   // ������ �������� ��ȭ ��ȣ�� ���� SchoolService service ��ü�� Instance Variable�� ArrayList al �������� �ش� �������� ������ �����ǰ�,
                    										   // �̸� Person Class�� toString() �޼��带 Overriding�� Student, Teacher, Employee Class�� toString() �޼��带 ���� ���
					System.out.println(delTel + " Delete OK");   // ������ �������� ��ȭ ��ȣ�� ���� �ش� �������� ���� ���� ���� ��� 
				} 
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // ������ �������� ��ȭ ��ȣ�� ���� �ش� �������� ������ SchoolService service ��ü�� Instance Variable�� ArrayList al �������� ������ ��,
			                                                         // ������ �������� ��ȭ ��ȣ�� �������� ������ SchoolService service ��ü�� �޼��� deletePersonByTel(String delTel)���� ���۵� delTel + "��ȣ�� �������� �ʾ� ���� �Ұ�!"�� ���
				}
			}
			else if(type1.equals("4"))   // 4. �˻�
			{
				System.out.println("�˻��� �������� ��ȭ ��ȣ�� �Է��ϼ���!");
				findTel = sc.nextLine();   // �˻��� �������� ��ȭ ��ȣ �Է�
				try 
				{
					p = service.findPersonByTel(findTel);   // �˻��� �������� ��ȭ ��ȣ�� SchoolService service ��ü�� �޼��� findPersonByTel(findTel)�� Local Variable�� ����
					System.out.println(p);   // �˻��� �������� ��ȭ ��ȣ�� ���� SchoolService service ��ü�� Instance Variable�� ArrayList al �������� �ش� �������� ������ �˻��ǰ�,
					                              // �̸� Person Class�� toString() �޼��带 Overriding�� Student, Teacher, Employee Class�� toString() �޼��带 ���� ���
				} 
				catch (PersonNotFoundException pe) 
				{
					System.out.println(pe.getMessage());   // �˻��� �������� ��ȭ ��ȣ�� ���� �ش� �������� ������ SchoolService service ��ü�� Instance Variable�� ArrayList al �������� �˻��� ��,
                                                                     // �˻��� �������� ��ȭ ��ȣ�� �������� ������ SchoolService service ��ü�� �޼��� findPersonByTel(findTel)���� ���۵� findTel + "��ȣ�� �������� �ʾ� ��ȸ �Ұ�!"�� ���
				}
			}
			else if(type1.equals("5"))   // 5. ��ü ȸ�� ����
			{
				System.out.println("**********��ü ������ ����**********");
				
				try 
				{
					service.printAll();   // SchoolService service ��ü�� �޼��� printAll()�� ���� ��ü ȸ�� ���� ���
				} 
				catch (ClassNotFoundException | IOException e) 
				{
					e.printStackTrace();
				}   
			}
			else if(type1.equals("6"))   // 6. ����
			{
				System.out.println("**********�л� ���� ���α׷��� �����մϴ�!**********");
				flag = true;   // flag�� true�� �Ҵ��� �� ���� Loop Ż��
			}
			else   // �߸��� �Է°��̸�
			{
				System.out.println("�߸��� �Է°��Դϴ�!");
			}
		}
	}
}
