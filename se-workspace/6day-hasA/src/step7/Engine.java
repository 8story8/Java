package step7;

public class Engine {
	private String type;
	private int displacement;

	public Engine(String type, int displacement)
	{
		this.type = type;
		this.displacement = displacement;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

	public void setDisplacement() {
		this.displacement = displacement;
	}

	public int getDisplacement() {
		return this.displacement;
	}
}
