package step4;

public class Person extends Animal {
	public void play()   // Method Overriding
	{
		System.out.println("사람이 데이트하며 놀다.");
	}
	
	public void ticketing()   // Person의 독자적인 메서드
	{
		System.out.println("사람이 티켓을 구매하다.");
	}
}
