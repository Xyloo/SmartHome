package devices.impl;

import devices.configs.SmartPlugConfig;
import devices.mediator.Mediator;
import devices.visitor.SmartDeviceVisitor;
import util.DeviceManager;

// Tydzień 1, Wzorzec Prototype 1
// Wzorzec prototypu pozwala na tworzenie obiektów na podstawie innych obiektów.
// Umożliwia to tworzenie nowych obiektów na podstawie istniejących z zachowaniem ich stanu.
public class SmartPlug extends AbstractSmartDevice implements SmartDevice, Cloneable {
    public static final String CONFIG_KEY = "SmartPlugConfig";
    private Mediator mediator;

    public SmartPlug(){
        SmartPlugConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, SmartPlugConfig.class);
        isOn = config.isOn();
        name = config.getDeviceName();
    }

    public SmartPlug(String deviceName) {
        this();
        if(deviceName != null && !deviceName.isEmpty()){
            this.name = deviceName;
        }
    }

    @Override
    public String getStatus() {
        return name + " is " + (isOn ? "ON" : "OFF");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("SMART_PLUG_OFF")){
            this.turnOff();
        }
    }

    @Override
    public SmartPlug clone() {
        try {
            return (SmartPlug) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }

}
// Koniec, Tydzień 1, Wzorzec Prototype 1