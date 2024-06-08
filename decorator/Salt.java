package decorator;

/**
 * @author Ahmad Alrefai
 * 
 */
public class Salt extends SandwichDecorator {

    public Salt(Sandwich sandwich) {
        super(sandwich);
    }


    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Salt";
    }
}
