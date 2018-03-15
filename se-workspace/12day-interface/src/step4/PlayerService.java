package step4;

public class PlayerService 
{
	private Player[] list;
	private int index;
	
	public PlayerService(int length) 
	{
		this.list = new Player[length];
	}
	
	public void addPlayer(Player p) 
	{
		this.list[index++] = p;
	}
	
	public void executeAll() 
	{
		for(int i = 0; i < index; i++)
		{
			if(this.list[i] instanceof CDPlayer)
			{
				((CDPlayer)this.list[i]).insertCD();
			}
			this.list[i].play();
		}
	}
}
