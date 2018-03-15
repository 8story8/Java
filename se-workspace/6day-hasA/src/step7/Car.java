package step7;

public class Car {
	
	private String model;
	private Engine engine;
	
	public Car(String model, Engine engine)
	{
		this.model = model;
		this.engine = engine;
	}

	public String getModel() {
		return this.model;
	}

	public void setEngine(Engine engine)
	{
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return this.engine;
	}
}
