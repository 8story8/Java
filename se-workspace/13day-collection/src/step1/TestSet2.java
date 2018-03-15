package step1;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet2 {

	public static void main(String[] args) 
	{
		// Set �迭 TreeSet Ŭ������ Generic �����ϴ� ����
		// �Ʒ� set���� String Ÿ���� ��Ҹ� �߰��� �� �ֵ��� Generic�� ����
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("�跡��");
		ts.add("�ſ���");
		// ts.add(1);   // Compile Error : String Ÿ�Ը� �����ϰ� Generic�� ����

		ts.add("������");
		ts.add("�ſ���"); // �ߺ� ��� ����
		System.out.println(ts);
		
		System.out.println("********************");
		
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		hs.add("A");
		hs.add("D");
		hs.add("B");
		System.out.println(hs);   // �߰��� ������ ����Ͽ� A, D, B�� ���
	}
}
