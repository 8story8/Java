package step4;

public class TestInterface4 
{
	public static void main(String[] args) 
	{
		PlayerService service = new PlayerService(10);
	 
		service.addPlayer(new GomPlayer());
		service.addPlayer(new AlSongPlayer());
		service.addPlayer(new CDPlayer());
		
		service.executeAll();   // GomPlayer가 동영상 재생하다.
									// AlSongPlayer가 음악 재생하다.		
									// CDPlayer에 CD를 넣다.
									// CDPlayer가 CD 재생하다.
	}
}
