package factory;

/**
 * @author Ahmad Alrefai
 * 
 */
public class Turtle extends Enemy {

    public Turtle() {
        setName("Turtle");
        setDamage(5);
        setHealth(33);
    }

    @Override
    public void takeDamage(int value) {
        if (getHealth() > 0) {
            setHealth(getHealth() - value);
            System.out.printf("%s Took [%d] damage and health is [%d] %n", getName(), value, getHealth());
        }
    }

    @Override
    public int attack() {
        return getDamage();
    }
}
