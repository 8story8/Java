package step3;

import step2.Fighter;
import step2.Flyer;

public class FlyerService 
{
	private Flyer[] list;
	private int index;
	
	FlyerService(int length)
	{
		this.list = new Flyer[length];
	}

	public void addFlyer(Flyer f) 
	{
		this.list[index++] = f;
	}

	public void executeFlyerAll() 
	{
		for(int i = 0; i < index; i++)
		{
			this.list[i].fly();
		}
	}

	public void executeFighterAll() 
	{
		for(int i = 0; i < index; i++)
		{
			if(this.list[i] instanceof Fighter)
			{
				((Fighter) this.list[i]).fight();
			}
		}
	}
}
