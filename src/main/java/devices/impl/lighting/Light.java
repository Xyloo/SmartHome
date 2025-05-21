package devices.impl.lighting;

import devices.impl.AbstractSmartDevice;
import devices.configs.LightConfig;
import devices.impl.LightBrightnessConstants;
import devices.mediator.Mediator;
import devices.memento.LightMemento;
import devices.observer.Observer;
import devices.strategy.lighting.BrightnessStrategy;
import devices.visitor.SmartDeviceVisitor;
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
        String brightnessString = " Brightness: " + brightness;
        return "Light [" + id + "] is " + (isOn ? "ON" + brightnessString : "OFF");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        System.out.println("Light handling event: " + event);
        switch (event) {
            case "LIGHTS_TURN_OFF" -> {
                System.out.println("Smart light - setting brightness to 0");
                setBrightness(LightBrightnessConstants.LIGHT_OFF);
            }
            case "activateSecurityMode" -> {
                util.SmartLogger.getInstance().log("Event: activateSecurityMode; Turning on brightness");
                turnOn();
                setBrightness(LightBrightnessConstants.LIGHT_DIM);
            }
            case "deactivateSecurityMode" -> {
                util.SmartLogger.getInstance().log("Event: deactivateSecurityMode; Turning off lights");
                turnOff();
            }
        }
    }

    @Override
    public void update(Object value) {
        if(value instanceof String && value.equals("MOTION_DETECTED")) {
            turnOn();
            setBrightness(LightBrightnessConstants.LIGHT_BRIGHT);
        }
    }

    public void applyBrightnessStrategy(BrightnessStrategy strategy) {
        strategy.apply(this);
    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }

    public LightMemento save(){
        return new LightMemento(isOn, brightness);
    }

    public void restore(LightMemento memento){
        isOn = memento.isOn();
        brightness = memento.getBrightness();
    }
}

