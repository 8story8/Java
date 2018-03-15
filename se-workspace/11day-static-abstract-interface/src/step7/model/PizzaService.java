package step7.model;

public abstract class PizzaService {
	
	protected void prepare()
	{
		System.out.println("도우를 만들다.");
	}
	
	protected abstract void topping();
	
	protected void bake()
	{
		System.out.println("굽다.");
	}
	
	protected void cut()
	{
		System.out.println("자르다.");
	}
	
	protected void box()
	{
		System.out.println("포장을 하다.");
	}
	
	// Template Method
	public void makePizza()
	{
		prepare();
		topping();
		bake();
		cut();
		box();
	}
}
