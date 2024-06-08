package factory;

/**
 * @author Ahmad Alrefai
 * 
 */
public class Bird extends Enemy {

    public Bird() {
        setName("Bird");
        setDamage(15);
        setHealth(45);
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
