package step2;

// 부모 클래스 Bird가 implements한 Flyer의 하위 계층 구조에 편입

public class Eagle extends Bird
{
	@Override
	public void fly()
	{
		System.out.println("독수리가 날다.");
	}
}
