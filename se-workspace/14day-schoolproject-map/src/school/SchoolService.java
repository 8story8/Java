package school;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class SchoolService 
{
	private LinkedHashMap<String, Person> lhm = new LinkedHashMap<String, Person>();
	
	public void addPerson(Person p) 
	{
		if(lhm.containsKey(p.getTel()) == false)
		{
			lhm.put(p.getTel(), p);
		}
		else
		{
			System.out.println(p.getTel() + "��ȣ�� �����Ͽ� �߰� �Ұ�!");
		}
	}

	public Person findPersonByTel(String tel) 
	{
		return lhm.get(tel);
	}	
	
	public void updatePerson(Person p) 
	{
		if(lhm.containsKey(p.getTel()) == true)
		{
			lhm.put(p.getTel(), p);
		}
		else
		{
			System.out.println(p.getTel() + "��ȣ�� �����Ͽ� ���� �Ұ�!");
		}
	}
	
	public void deletePersonByTel(String tel) 
	{
		lhm.remove(tel);
	}
	
	public void printAll() 
	{
		Iterator<Person> it = lhm.values().iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
