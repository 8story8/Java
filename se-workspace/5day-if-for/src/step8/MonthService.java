package step8;

public class MonthService {
	/*
	2�� : 28
	4, 6, 9, 11�� : 30��
	1, 3, 5, 7, 8, 10, 12�� : 31��
	*/
	private int month;
	
	public void printLastDay(int month) {
		// TODO Auto-generated method stub
		this.month = month;
		switch(month)
		{
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 :  case 12 :
			System.out.println(this.month +"���� ���������� 31���Դϴ�.");
			break;
		case 2 :
			System.out.println(this.month +"���� ���������� 28���Դϴ�.");
			break;
		case 4 : case 6 : case 9 : case 11 : 
			System.out.println(this.month +"���� ���������� 30���Դϴ�.");
			break;
		default :
			System.out.println("�߸��� �Է°��Դϴ�.");
			break;
		}
	}
}
