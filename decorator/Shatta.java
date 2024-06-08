package decorator;

/**
 * @author Ahmad Alrefai
 * 
 */
public class Shatta extends SandwichDecorator {

    public Shatta(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Shatta";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.8;
    }
}
