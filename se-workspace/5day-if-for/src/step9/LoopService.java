package step9;

public class LoopService {
	
	public void printInfo(String item, int count) {
		for(int i = 1; i <= count; i++)
		{
			System.out.println(item + " " + i + "��");
		}
	}

	/*
	public void printInfoLimit(String item, int count, int limit) {
		
			if(limit == 0)
			{
				for(int i = 1; i <= count; i++)
				{
					System.out.println("���� " + i + "��");
				}
			}
			else
			{
				for(int j = 1; j<= limit; j++)
				{
					System.out.println("���� " + j + "��");
				}
			}
		}
	*/
	
	public void printInfoLimit(String item, int count, int limit) 
	{
		for(int i = 1 ; i <= count; i++)
		{
			System.out.println(item + " "+ i + "��");
			
			if(limit == i)
			{      
				break; 
			}
		}
	}
}
