package devices;

import devices.configs.SmartPlugConfig;
import util.DeviceManager;

// Tydzień 1, Wzorzec Prototype 1
// Wzorzec prototypu pozwala na tworzenie obiektów na podstawie innych obiektów.
// Umożliwia to tworzenie nowych obiektów na podstawie istniejących z zachowaniem ich stanu.
public class SmartPlug implements SmartDevice, Cloneable {
    public static final String CONFIG_KEY = "SmartPlugConfig";
    private boolean isOn;
    private String deviceName;

    public SmartPlug(){
        SmartPlugConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, SmartPlugConfig.class);
        isOn = config.isOn();
        deviceName = config.getDeviceName();
    }

    public SmartPlug(String deviceName) {
        this();
        if(deviceName != null && !deviceName.isEmpty()){
            this.deviceName = deviceName;
        }
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