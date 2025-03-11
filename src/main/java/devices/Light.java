package devices;

public class Light implements SmartDevice {
    private boolean isOn;

    @Override
    public void turnOn() { isOn = true; }

    @Override
    public void turnOff() { isOn = false; }

    @Override
    public String getStatus() {
        return "Light is " + (isOn ? "ON" : "OFF");
    }
}

