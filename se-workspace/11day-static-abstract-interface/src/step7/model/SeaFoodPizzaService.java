package step7.model;

public class SeaFoodPizzaService extends PizzaService{
	@Override
	protected void topping() {
		System.out.println("해산물 토핑");
	}
}
