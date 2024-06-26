package adapter;

/**
 * @author Ahmad Alrefai
 * 
 */

//Client
public class Client {

    public static void main(String[] args) {
        Vehicle car = new Car();

        Vehicle bicycle = new BicycleAdapter(new Bicycle());

        playWithVehicle(car);

        playWithVehicle(bicycle);
    }

    private static void playWithVehicle(Vehicle vehicle) {

        vehicle.accelerate();
        vehicle.pushBreak();
        vehicle.soundHorn();
        System.out.println("\n");
    }
}
