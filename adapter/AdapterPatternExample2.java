package adapter;

//Target interface
interface RemoteControl {
 public void switchOn();
 public void switchOff();
 public void setChannel(int channel);
}

//Adaptee class
class OldTV {
 public void on() {
     System.out.println("Old TV is on");
 }

 public void off() {
     System.out.println("Old TV is off");
 }

 public void tuneChannel(String channelName) {
     System.out.println("Old TV is tuned to " + channelName);
 }
}

//Adapter class
class TVAdapter implements RemoteControl {
 private OldTV oldTV;

 public TVAdapter(OldTV oldTV) {
     this.oldTV = oldTV;
 }

 @Override
 public void switchOn() {
     oldTV.on();
 }

 @Override
 public void switchOff() {
     oldTV.off();
 }

 @Override
 public void setChannel(int channel) {
     String channelName;
     switch (channel) {
         case 1:
             channelName = "Channel 1";
             break;
         case 2:
             channelName = "Channel 2";
             break;
         // ... add more cases for other channels
         default:
             channelName = "Invalid channel";
             break;
     }
     oldTV.tuneChannel(channelName);
 }
}

public class AdapterPatternExample2 {
	
	public static void main(String[] args) {
        OldTV oldTV = new OldTV();
        RemoteControl remoteControl = new TVAdapter(oldTV);

        remoteControl.switchOn();
        remoteControl.setChannel(1);
        remoteControl.setChannel(2);
        remoteControl.switchOff();
    }
}
