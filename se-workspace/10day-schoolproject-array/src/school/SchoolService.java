package school;

public class SchoolService 
{
	private Person[] personList;
	private int index;

	public SchoolService(int length) 
	{
		this.personList = new Person[length];
	}

	public void addPerson(Person p) 
	{
		boolean flag = false;
		
		if(findPersonByTel(p.getTel()) == null)
		{
			this.personList[index++] = p;
		}
		else
		{
			System.out.println(p.getTel() + "번호가 존재하여 추가 불가!");
		}
	}

	public Person findPersonByTel(String tel) 
	{
		Person p = null;
		
		for(int i = 0; i < index; i++)
		{
			if(tel.equals(personList[i].getTel()))
			{
				p = personList[i];
				break;
			}
		}
		return p;
	}

	public void updatePerson(Person p) 
	{
		boolean flag = false;
		
		for(int i = 0; i < index; i++)
		{
			if(p.getTel().equals(personList[i].getTel()))
			{
				flag = true;
				personList[i] = p;
				break;
			}
		}
		
		if(flag == false)
		{
			System.out.println(p.getTel() + "번호를 가진 구성원이 없으므로 수정 불가!");
		}
	}
	
	public void deletePersonByTel(String tel) 
	{
		for(int i = 0; i < index; i++)
		{
			if(tel.equals(personList[i].getTel()))
			{
				for(int j = i; j < index; j++)
				{
					if(j + 1 == personList.length)
					{
						personList[j] = null;
					}
					else
					{
						personList[i] = personList[i + 1];
					}
				}
				index--;
			}
		}
	}
	
	public void printAll() 
	{
		for(int i = 0; i < index; i++)
		{
			System.out.println(personList[i].toString());
		}
	}
}
