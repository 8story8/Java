package step4;

public class CDPlayer implements Player
{
	@Override
	public void play() 
	{
		System.out.println("CDPlayer가 CD 재생하다.");
	}
	
	public void insertCD()
	{
		System.out.println("CDPlayer에 CD를 넣다.");
	}
}
