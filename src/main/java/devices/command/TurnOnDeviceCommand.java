package devices.command;

import devices.impl.SmartDevice;

// Tydzien 4, Wzorzec Command 2
public class TurnOnDeviceCommand implements Command {

    private SmartDevice device;

    public TurnOnDeviceCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }

    @Override
    public void undo(){
        device.turnOff();
    }
}
// Koniec Tydzien 4, Wzorzec Command 2