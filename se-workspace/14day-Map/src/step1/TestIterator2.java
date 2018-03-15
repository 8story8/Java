package step1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class DeliveryService
{
	public Collection<String> getCollection(String type)
	{
		Collection<String> c = null;
		if(type.equals("����"))
		{
			c = new ArrayList<String>();
			c.add("���̽�");
			c.add("ó��ó��");
			c.add("�鼼��");
		}
		else if(type.equals("����"))
		{
			c = new LinkedHashSet<String>();
			c.add("Ŭ����");
			c.add("ī��");
			c.add("��׽�");
		}
		return c;
	}
}

public class TestIterator2 {

	public static void main(String[] args) {
		DeliveryService ds = new DeliveryService();
		
		Collection<String> c = ds.getCollection("����");
		
		if(c instanceof List)
		{
			System.out.println("List ����ü");
		}
		else if(c instanceof Set)
		{
			System.out.println("Set ����ü");
		}
		
		// Set �迭�̵� List �迭�̵� ������� ǥ��ȭ�� ������� ��ҵ��� �ݺ� ������ �� �ִ�.
		Iterator<String> it = c.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
