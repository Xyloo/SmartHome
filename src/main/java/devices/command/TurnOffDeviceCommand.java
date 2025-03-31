package devices.command;

import devices.impl.SmartDevice;

// Tydzien 4, Wzorzec Command 2
public class TurnOffDeviceCommand implements Command {

    SmartDevice device;
    public TurnOffDeviceCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }

    @Override
    public void undo() {
        device.turnOff();
    }
}
// Koniec Tydzien 4, Wzorzec Command 2