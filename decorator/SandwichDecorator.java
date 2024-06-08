package decorator;

/**
 * The Decorator class
 * @author Ahmad Alrefai
 * 
 */
public abstract class SandwichDecorator implements Sandwich {

    private Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return this.sandwich.getDescription();
    }

    @Override
    public double getCost() {
        return this.sandwich.getCost();
    }
}
