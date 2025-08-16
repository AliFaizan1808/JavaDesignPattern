package pattern.structural;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Decorator {
	public static void main(String[] args) {
		Pizza order = new SimplePizza();
		order = new TomatoToDecorator(order);
		order = new OnionToDecorator(order);
		System.out.println(order.getTopping());
	}

}


interface Pizza{
	String getTopping();
	Double getCost();
}


class SimplePizza implements Pizza{

	@Override
	public String getTopping() {
		return "Simple Margharita Pizza";
	}

	@Override
	public Double getCost() {
		return 100.00;
	}

}

abstract class PizzaDecorator implements Pizza{

	protected final Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}


	@Override
	public String getTopping() {
		return pizza.getTopping();
	}

	@Override
	public Double getCost() {
		return pizza.getCost();
	}
}

class TomatoToDecorator extends PizzaDecorator{

	public TomatoToDecorator(Pizza pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTopping() {
		return pizza.getTopping() + ", with tomato";
	}

	@Override
	public Double getCost() {
		return pizza.getCost() + 200.00;
	}


}


class OnionToDecorator extends PizzaDecorator{

	public OnionToDecorator(Pizza pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTopping() {
		return pizza.getTopping() + ", with Onion"  + Timestamp.valueOf(LocalDateTime.now().minusMonths(6));
	}

	@Override
	public Double getCost() {
		return pizza.getCost() + 200.00;
	}


}


