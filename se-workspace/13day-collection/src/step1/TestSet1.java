package step1;

import java.util.Set;
import java.util.TreeSet;

public class TestSet1 
{
	public static void main(String[] args) 
	{
		TreeSet ts = new TreeSet();
		
		ts.add("�����");
		ts.add("������");
		System.out.println(ts.size());
		
		ts.add("������");   // �ߺ��ǹǷ� �߰� �ȵ�
		System.out.println(ts.size());
		
		// toString()�� Overriding�Ǿ� �ּҰ� ��� Set�� ���� ��Ұ� ��ȯ�Ǿ� ���
		System.out.println(ts);
		ts.add("�跡��");
		
		// TreeSet�� ���� ����� ����Ǿ� �־ ��, ��, �� ������ ���
		System.out.println(ts);
		
		ts.clear();
		System.out.println(ts);
		
		ts.add("b");
		ts.add("a");
		ts.add("c");
		System.out.println(ts);
		
		ts.clear();
		System.out.println(ts);
		
		ts.add("5");
		ts.add("3");
		ts.add("4");
		System.out.println(ts);
		
		System.out.println(ts.last());
	}
}
