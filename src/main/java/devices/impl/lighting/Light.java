package devices.impl.lighting;

import devices.impl.AbstractSmartDevice;
import devices.configs.LightConfig;
import devices.mediator.Mediator;
import devices.observer.Observer;
import util.DeviceManager;

public class Light extends AbstractSmartDevice implements LightingDevice, Observer {
    public static final String CONFIG_KEY = "Light";
    private int brightness;
    private Mediator mediator;

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

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        System.out.println("Light handling event: " + event);
        if(event.equals("LIGHTS_TURN_OFF")) {
            System.out.println("Smart light - setting brightness to 0");
            setBrightness(0);
        }
        else if(event.equals("activateSecurityMode")){
            util.SmartLogger.getInstance().log("Event: activateSecurityMode; Turning on brightness");
            turnOn();
            setBrightness(50);
        }else if(event.equals("deactivateSecurityMode")){
            util.SmartLogger.getInstance().log("Event: deactivateSecurityMode; Turning off lights");
            turnOff();
        }
    }

    @Override
    public void update(Object value) {
        if(value instanceof String && value.equals("MOTION_DETECTED")) {
            turnOn();
            setBrightness(80);
        }
    }
}

