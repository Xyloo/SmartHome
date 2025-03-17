package devices.impl.lighting;

import devices.impl.AbstractSmartDevice;
import devices.configs.LightConfig;
import util.DeviceManager;

public class Light extends AbstractSmartDevice implements LightingDevice {
    public static final String CONFIG_KEY = "Light";
    private int brightness;

    public Light() {
        LightConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, LightConfig.class);
        isOn = config.getInitialState();
        brightness = config.getBrightness();
    }

    @Override
    public void setBrightness( int brightness ) {
        this.brightness = brightness;
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public String getStatus() {
        return "Light [" + id + "] is " + (isOn ? "ON" : "OFF") + " Brightness: " + brightness;
    }
}

