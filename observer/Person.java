package observer;

/**
 * Example of a Person observer
 * @author Ahmad Alrefai
 * 
 */
public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.printf("%s Got new notification: %s%n", this.name, message);
    }
}
