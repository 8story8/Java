package step4;

public class TestObjectInit2 {

	public static void main(String[] args) {
		MyDate m = new MyDate(1, 12);
		System.out.println(m.getMonth() + "�� " + m.getDay() + "��");		// 1�� 12���� ���

		MyDate m2 = new MyDate(1, 32);
		System.out.println(m2.getMonth() + "�� " + m2.getDay() + "��");	// 1�� 1���� ���
		
		MyDate m3 = new MyDate(13, 12);
		System.out.println(m3.getMonth() + "�� " + m3.getDay() + "��");	// 1�� 1���� ���
		/*
		���� 1 ~ 12 ����
		���� 1 ~ 13 ����
		�� �� �ϳ��� �������� ������ ������ 1�� 1�� Setting
		 */
	}
}
