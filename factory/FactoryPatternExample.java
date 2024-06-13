package factory;

/**
 * @author Ahmad Alrefai
 * {@link Authenticator}
 */

//Product interface
	interface Vehicle {
	    void drive();
	}

	// Concrete products
	class Car implements Vehicle {
	    @Override
	    public void drive() {
	        System.out.println("Driving a car.");
	    }
	}

	class Truck implements Vehicle {
	    @Override
	    public void drive() {
	        System.out.println("Driving a truck.");
	    }
	}

	// Factory class
	class VehicleFactory {
	    public static Vehicle createVehicle(String type) {
	        if (type.equalsIgnoreCase("car")) {
	            return new Car();
	        } else if (type.equalsIgnoreCase("truck")) {
	            return new Truck();
	        } else {
	            throw new IllegalArgumentException("Invalid vehicle type.");
	        }
	    }
	}

	
public class FactoryPatternExample {
	
	// Client code
	
	    public static void main(String[] args) {
	        Vehicle car = VehicleFactory.createVehicle("car");
	        car.drive(); // Output: Driving a car.

	        Vehicle truck = VehicleFactory.createVehicle("truck");
	        truck.drive(); // Output: Driving a truck.
	    }
	

}
