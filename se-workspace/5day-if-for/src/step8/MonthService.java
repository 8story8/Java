package step8;

public class MonthService {
	/*
	2월 : 28
	4, 6, 9, 11월 : 30일
	1, 3, 5, 7, 8, 10, 12월 : 31일
	*/
	private int month;
	
	public void printLastDay(int month) {
		// TODO Auto-generated method stub
		this.month = month;
		switch(month)
		{
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 :  case 12 :
			System.out.println(this.month +"월의 마지막일은 31일입니다.");
			break;
		case 2 :
			System.out.println(this.month +"월의 마지막일은 28일입니다.");
			break;
		case 4 : case 6 : case 9 : case 11 : 
			System.out.println(this.month +"월의 마지막일은 30일입니다.");
			break;
		default :
			System.out.println("잘못된 입력값입니다.");
			break;
		}
	}
}
