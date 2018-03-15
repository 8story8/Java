package step8;

public class TestArraySort {

	public static void main(String[] args) {
		int[] point = {4, 2, 3, 1};
		
		printArray(point);  // 4 3 2 1
		
		System.out.println("�������� ����");
		
		// �迭 �������� ����
		int temp = 0;
		for(int i = 0; i < point.length; i++)
		{
			for(int j = i+1; j < point.length; j++)
			{
				if(point[i] > point[j])
				{
					temp = point[j];
					point[j] = point[i];
					point[i] = temp;
				}
			}
		}
		// ...
		
		printArray(point);   // 1 2 3 4

	}
	
	public static void printArray(int [] point)
	{
		for(int i = 0; i < point.length; i++)
		{
			System.out.print(point[i] + " ");
		}
		System.out.println();
	}

}
