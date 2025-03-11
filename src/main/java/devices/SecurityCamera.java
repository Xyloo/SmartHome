package devices;

public class SecurityCamera implements SmartDevice {
    private boolean recording;

    @Override
    public void turnOn() { recording = true; }

    @Override
    public void turnOff() { recording = false; }

    @Override
    public String getStatus() {
        return "Security Camera is " + (recording ? "recording" : "idle");
    }
}

