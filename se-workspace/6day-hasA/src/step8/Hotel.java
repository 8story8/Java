package step8;

public class Hotel {
	
	private String name;
	private SweetRoom sr;

	public Hotel(String name, SweetRoom sr)
	{
		this.name = name;
		this.sr = sr;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public SweetRoom getSweetRoom() {
		// TODO Auto-generated method stub
		return this.sr;
	}
}
