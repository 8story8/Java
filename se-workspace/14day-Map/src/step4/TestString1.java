package step4;

public class TestString1 
{
	public static void main(String[] args) 
	{
		String name1 = "������";
		String name2 = new String("������");
		String name3 = "������";
		
		// ���ڿ� �񱳴� equals()�� �ؾ� �Ѵ�.
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
		System.out.println(name1.equals(name2));
	
		System.out.println("********************");
		
		// indexOf(���ڿ�) -> index�� ��ȯ, ������ -1�� ��ȯ
		System.out.println(name1.indexOf("��"));
		System.out.println(name1.indexOf("��"));
		System.out.println(name1.indexOf("��"));
		
		System.out.println("********************");
		
		String name4 = " ������";	
		
		// name4 ���� ���鶧���� false
		System.out.println(name1.equals(name4));
		
		// trim()�� �̿��� �翩���� �����ϸ� �ȴ�.
		System.out.println(name1.equals(name4.trim()));
		
		System.out.println("********************");
		
		String name5 = "�������ٸ�";
		System.out.println(name5.substring(2));   // ���ٸ�, 2�ε��� ~
		// substring(beginIndex, endIndex);�� �̿��� ���ٸ� ���
		System.out.println(name5.substring(2, 4));
		// name5�� ���� �����ϸ� true
		System.out.println(name5.startsWith("����"));
		// name5�� ���� �������� true or false
		System.out.println(name5.endsWith("��"));
		
		System.out.println("********************");
		
		String name6 = "javaking";
		String name7 = "JAVAking";
		System.out.println(name6.equals(name7));
		// ��ҹ��� ���о��� ��
		System.out.println(name6.equalsIgnoreCase(name7));
		
		System.out.println("********************");
		
		String name8 = "���ε�Ʈ����";
		System.out.println(name8.replace("Ʈ����", "��"));
		
		System.out.println("********************");
		
		String name9 = "org.eclipse.wst.ws.explorer_1.0.900.v201603171951.jar";
		System.out.println(name9.lastIndexOf("."));   // ������ .�ε��� 49��ȯ
		System.out.println(name9.indexOf("."));   	  // ù ���� .�ε��� 3��ȯ
		
		System.out.println("********************");
		
		String menu = "����,����,����,����,�밡��";
		String ma[] = menu.split(",");
		
		for(int i = 0; i < ma.length; i++)
		{
			System.out.println(ma[i]);
		}
	}
}
