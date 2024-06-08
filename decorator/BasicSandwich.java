package decorator;

/**
 * Concrete Implemenation of the Interface
 * @author Ahmad Alrefai
 * 
 */
public class BasicSandwich implements Sandwich{

    @Override
    public double getCost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Bread";
    }
}
