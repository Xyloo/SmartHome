package devices.impl.lighting;

import devices.impl.SmartDevice;

public class BasicLight implements SmartDevice
{
    private boolean on;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    public String getStatus() {
        return on ? "ON" : "OFF";
    }
}
