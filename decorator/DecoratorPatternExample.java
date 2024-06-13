package decorator;

//Component interface
interface Beverage {
	String getDescription();

	double cost();
}

//Concrete component
class Espresso implements Beverage {
	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}
}

//Decorator abstract class
abstract class BeverageDecorator implements Beverage {
	protected Beverage beverage;

	public BeverageDecorator(Beverage beverage) {
		this.beverage = beverage;
	}

	public abstract String getDescription();
}

//Concrete decorator
class Milk extends BeverageDecorator {
	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.5;
	}
}

//Another concrete decorator
class Mocha extends BeverageDecorator {
	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.7;
	}
}

public class DecoratorPatternExample {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverageWithMilk = new Milk(beverage);
		System.out.println(beverageWithMilk.getDescription() + " $" + beverageWithMilk.cost());

		Beverage beverageWithMilkAndMocha = new Mocha(beverageWithMilk);
		System.out.println(beverageWithMilkAndMocha.getDescription() + " $" + beverageWithMilkAndMocha.cost());
	}
}
