package step11;

public class TestArray3 {
	public static void main(String[] args) {
		
		// 배열 선언 생성 할당 동시
		int[] point ={200, 300, 100, 400, 600};
		
		int avg = 0;
		
		for(int i = 0; i < point.length; i++)
		{
			avg += point[i]/point.length;
		}
		
		System.out.println("평균 포인트 : " + avg);
	}
}
