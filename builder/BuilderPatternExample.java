package builder;

/**
 * 
 * @author Ahmad Alrefai
 */

//Product class
class Computer {
 private String cpu;
 private String ram;
 private String storage;
 private boolean isGraphicsCardEnabled;
 private boolean isBluetoothEnabled;

 public String getCpu() {
     return cpu;
 }

 public String getRam() {
     return ram;
 }

 public String getStorage() {
     return storage;
 }

 public boolean isGraphicsCardEnabled() {
     return isGraphicsCardEnabled;
 }

 public boolean isBluetoothEnabled() {
     return isBluetoothEnabled;
 }

 private Computer(ComputerBuilder builder) {
     this.cpu = builder.cpu;
     this.ram = builder.ram;
     this.storage = builder.storage;
     this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
     this.isBluetoothEnabled = builder.isBluetoothEnabled;
 }

 // Builder class
 public static class ComputerBuilder {
     private String cpu;
     private String ram;
     private String storage;
     private boolean isGraphicsCardEnabled;
     private boolean isBluetoothEnabled;

     public ComputerBuilder setCpu(String cpu) {
         this.cpu = cpu;
         return this;
     }

     public ComputerBuilder setRam(String ram) {
         this.ram = ram;
         return this;
     }

     public ComputerBuilder setStorage(String storage) {
         this.storage = storage;
         return this;
     }

     public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
         this.isGraphicsCardEnabled = isGraphicsCardEnabled;
         return this;
     }

     public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
         this.isBluetoothEnabled = isBluetoothEnabled;
         return this;
     }

     public Computer build() {
         return new Computer(this);
     }
 }
}


public class BuilderPatternExample {

	 public static void main(String[] args) {
	        Computer computer = new Computer.ComputerBuilder()
	                .setCpu("Intel Core i7")
	                .setRam("16GB")
	                .setStorage("512GB SSD")
	                .setGraphicsCardEnabled(true)
	                .setBluetoothEnabled(true)
	                .build();

	        System.out.println("CPU: " + computer.getCpu());
	        System.out.println("RAM: " + computer.getRam());
	        System.out.println("Storage: " + computer.getStorage());
	        System.out.println("Graphics Card Enabled: " + computer.isGraphicsCardEnabled());
	        System.out.println("Bluetooth Enabled: " + computer.isBluetoothEnabled());
	    }
}
