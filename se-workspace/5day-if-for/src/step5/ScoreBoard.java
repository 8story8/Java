package step5;

public class ScoreBoard {

	public void printGrade(int point) {
		/*
		if(point >=90 && point <= 100)
		{
			System.out.println("수");
		}
		else if(point >=80 && point <= 90)
		{
			System.out.println("우");
		}
		else if(point >=70 && point <= 80)
		{
			System.out.println("미");
		}
		else if(point >=60 && point <= 70)
		{
			System.out.println("양");
		}
		else if(point >= 0 && point < 60)
		{
			System.out.println("가");
		}
		else
		{
			System.out.println("잘못된 입력값");
		}
		*/
		
		if(point > 100 || point < 0)
		{
			System.out.println("잘못된 입력값");
		}
		else if(point >= 90)
		{
			System.out.println("수");
		}
		else if(point >= 80)
		{
			System.out.println("우");
		}
		else if(point >= 70)
		{
			System.out.println("미");
		}
		else if(point >= 60)
		{
			System.out.println("양");
		}
		else if(point >= 0)
		{
			System.out.println("가");
		}
	}
}
