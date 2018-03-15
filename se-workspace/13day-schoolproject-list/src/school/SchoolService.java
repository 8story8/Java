package school;

import java.util.ArrayList;

public class SchoolService 
{
	private ArrayList<Person> al = new ArrayList<Person>();

	public void addPerson(Person p) 
	{
		if(findPersonByTel(p.getTel()) == null)
		{
			al.add(p);
		}
		else
		{
			System.out.println(p.getTel() + "번호가 존재하여 추가 불가!");
		}
	}

	public Person findPersonByTel(String tel) 
	{
		Person p = null;
		
		for(int i = 0; i < al.size(); i++)
		{
			if(tel.equals(al.get(i).getTel()))
			{
				p = al.get(i);
				break;
			}
		}
		
		return p;
	}
	
	public void updatePerson(Person p) 
	{
		boolean flag = false;
		
		for(int i = 0; i < al.size(); i++)
		{
			if(p.getTel().equals(al.get(i).getTel()))
			{
				flag = true;
				al.set(i, p);
				break;
			}
		}
		
		if(flag == false)
		{
			System.out.println(p.getTel() + "번호가 존재하여 수정 불가!");
		}
	}
	
	public void deletePersonByTel(String tel) 
	{
		for(int i = 0; i < al.size(); i++)
		{
			if(tel.equals(al.get(i).getTel()))
			{
				al.remove(i);
				break;
			}
		}
	}
	
	public void printAll() 
	{
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i));
		}
	}
}
