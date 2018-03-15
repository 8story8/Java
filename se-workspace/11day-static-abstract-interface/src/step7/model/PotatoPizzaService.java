package step7.model;

public class PotatoPizzaService extends PizzaService{
	@Override
	protected void topping() {
		System.out.println("감자 토핑");
	}
}
