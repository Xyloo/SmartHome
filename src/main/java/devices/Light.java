package devices;

import devices.configs.LightConfig;
import util.DeviceManager;

public class Light implements SmartDevice {
    public static final String CONFIG_KEY = "Light";
    private boolean isOn;
    private int brightness;

    public Light() {
        LightConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, LightConfig.class);
        isOn = config.getInitialState();
        brightness = config.getBrightness();
    }

    @Override
    public void turnOn() { isOn = true; }

    @Override
    public void turnOff() { isOn = false; }

    @Override
    public String getStatus() {
        return "Light is " + (isOn ? "ON" : "OFF") + " Brightness: " + brightness;
    }
}

