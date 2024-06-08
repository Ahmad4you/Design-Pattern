package command;

/**
 * @author Ahmad Alrefai
 * 
 */
public class TurnOffTVCommand implements Command {

    private TV tv;

    public TurnOffTVCommand(TV light) {
        this.tv = light;
    }

    @Override
    public void execute() {
        this.tv.turnOff();
    }

    @Override
    public void undo() {
        this.tv.turnOn();
    }
}
