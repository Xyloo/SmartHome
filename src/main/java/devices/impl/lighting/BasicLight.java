package devices.impl.lighting;

public class BasicLight
{
    private boolean on;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }

    public String getStatus() {
        return on ? "ON" : "OFF";
    }
}
