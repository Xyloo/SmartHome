package devices.bridge;

import devices.impl.SmartDevice;

//Tydzień 2, Wzorzec Bridge 2
public class BasicRemoteControl extends AbstractRemoteControl {
    public BasicRemoteControl(SmartDevice device) {
        super(device);
    }

    @Override
    public void turnOff() {
        util.SmartLogger.getInstance().log("[BasicRemoteControl] Turning off");
        device.turnOff();
    }

    @Override
    public void turnOn() {
        util.SmartLogger.getInstance().log("[BasicRemoteControl] Turning on");
        device.turnOn();
    }

    @Override
    public String getStatus() {
        util.SmartLogger.getInstance().log("[BasicRemoteControl] Getting status");
        return device.getStatus();
    }
}
//Koniec Tydzień 2, Wzorzec Bridge 2