package step7;

public class TestPrimitiveDataType {
	public static void main(String[] args) {
		// ������
		byte b1 = 11;
		// ���� : byte���� �ִ밪
		System.out.println(Byte.MAX_VALUE);
		// ���� : byte���� �ּҰ�
		System.out.println(Byte.MIN_VALUE);
		// byte b2 = 130;   // �ִ밪�� �����Ƿ� Error
		short s = 130;   // 2byte�̹Ƿ� ����
		int i = 131;   // 4byte�̹Ƿ� ����
		long lo = 130;   // 8byte�̹Ƿ� ����
		
		// �Ǽ���
		// float f = 3.14; // �Ǽ����� �⺻���� double�̹Ƿ� Error
		float f = 3.14f;   // float������ f�� ����� �˷��ش�.
		double d = 3.14;   // �Ǽ����� �⺻�� double 8byte
		
		// ������
		// char c = '�椾';   // char���� �ѹ��ڸ� �����ϹǷ� Error
		
		// ���� boolean���� ���� true or false�� ����
		boolean flag = true;
		boolean bo = false;
		
		System.out.println("--------------------");
		byte by1 = 1;
		byte by2 = 4;
		// byte by3 = by1 + by2 --> ���� �Ŀ��� �������� �⺻�� int������ �ν�
		// �ذ� ����� by3a�� Type�� int�� ����
		int by3a = by1 + by2;
		// �� �ٸ� �ذ� ����� ���� ����� byte������ Casting
		byte by3b = (byte) (by1+by2);
	}
}
