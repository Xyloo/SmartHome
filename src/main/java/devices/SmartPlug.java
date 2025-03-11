package devices;

// Tydzień 1, Wzorzec Prototype 1
// Wzorzec prototypu pozwala na tworzenie obiektów na podstawie innych obiektów.
// Umożliwia to tworzenie nowych obiektów na podstawie istniejących z zachowaniem ich stanu.
public class SmartPlug implements SmartDevice, Cloneable {
    private boolean isOn;
    private String deviceName;

    public SmartPlug(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void turnOn() { isOn = true; }

    @Override
    public void turnOff() { isOn = false; }

    @Override
    public String getStatus() {
        return deviceName + " is " + (isOn ? "ON" : "OFF");
    }

    @Override
    public SmartPlug clone() {
        try {
            return (SmartPlug) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }
}
// Koniec, Tydzień 1, Wzorzec Prototype 1