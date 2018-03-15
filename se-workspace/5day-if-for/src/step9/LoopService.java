package step9;

public class LoopService {
	
	public void printInfo(String item, int count) {
		for(int i = 1; i <= count; i++)
		{
			System.out.println(item + " " + i + "接");
		}
	}

	/*
	public void printInfoLimit(String item, int count, int limit) {
		
			if(limit == 0)
			{
				for(int i = 1; i <= count; i++)
				{
					System.out.println("持呼 " + i + "接");
				}
			}
			else
			{
				for(int j = 1; j<= limit; j++)
				{
					System.out.println("持呼 " + j + "接");
				}
			}
		}
	*/
	
	public void printInfoLimit(String item, int count, int limit) 
	{
		for(int i = 1 ; i <= count; i++)
		{
			System.out.println(item + " "+ i + "接");
			
			if(limit == i)
			{      
				break; 
			}
		}
	}
}
