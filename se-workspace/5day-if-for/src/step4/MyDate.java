package step4;

public class MyDate {
	private int day;
	private int month;
	
	public void setDay(int day)
	{
		if(day > 0 && day < 32)
		{
			this.day = day;
		}
		else
		{
			System.out.println("잘못된 일입니다.");
		}
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public void setMonth(int month)
	{
		if(month > 0  && month < 13)
		{
			this.month = month;
		}
		else
		{
			System.out.println("잘못된 월입니다.");
		}
	}
	
	public int getMonth()
	{
		return this.month;
	}
}
