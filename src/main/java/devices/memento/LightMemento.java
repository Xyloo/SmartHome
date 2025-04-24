package devices.memento;

public class LightMemento {
    private int brightness;
    private boolean isOn;

    public LightMemento(boolean isOn, int brightness) {
        this.isOn = isOn;
        this.brightness = brightness;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }
}
