package devices.bridge;

import devices.impl.SmartDevice;

public abstract class AbstractRemoteControl {
    protected SmartDevice device;

    public AbstractRemoteControl(SmartDevice device) {
        this.device = device;
    }

    abstract void turnOff();
    abstract void turnOn();
    abstract String getStatus();
}
