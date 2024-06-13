package adapter;

//Target interface
interface Socket {
 public Volt getVolt();
}

//Adaptee class
class Socket3Pin {
 public int getVoltage() {
     return 3;
 }
}

//Adapter class
class SocketAdapter implements Socket {
 private Socket3Pin socket3Pin;

 public SocketAdapter(Socket3Pin socket3Pin) {
     this.socket3Pin = socket3Pin;
 }

 @Override
 public Volt getVolt() {
     int voltage = socket3Pin.getVoltage();
     return convertVoltage(voltage);
 }

 private Volt convertVoltage(int voltage) {
     switch (voltage) {
         case 3:
             return Volt.THREE_VOLT;
         case 5:
             return Volt.FIVE_VOLT;
         default:
             throw new IllegalArgumentException("Invalid voltage: " + voltage);
     }
 }
}

//Volt enum
enum Volt {
 THREE_VOLT,
 FIVE_VOLT
}


public class AdapterPatternExample {
	
	public static void main(String[] args) {
        Socket3Pin socket3Pin = new Socket3Pin();
        SocketAdapter socketAdapter = new SocketAdapter(socket3Pin);

        Volt volt = socketAdapter.getVolt();
        System.out.println("Voltage: " + volt);
    }
}
