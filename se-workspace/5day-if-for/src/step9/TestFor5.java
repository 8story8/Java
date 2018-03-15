package step9;

public class TestFor5 {

	public static void main(String[] args) {
		
		/*
		System.out.print("test1\n\n");
		System.out.print("test2\t\t");
		System.out.print("test3");
		*/
		
		/*
		1	2	3	4	5
		1	2	3	4	5
		1	2	3	4	5
		*/
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 1; j <= 5; j++)
			{
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}
}
