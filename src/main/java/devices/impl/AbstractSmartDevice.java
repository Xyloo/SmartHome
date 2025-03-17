package devices.impl;

import java.util.UUID;

public abstract class AbstractSmartDevice implements SmartDevice {
    protected final String id;
    protected String name;
    protected int locationId;
    protected boolean isOn;

    public AbstractSmartDevice(){
        this.id = UUID.randomUUID().toString();
    }

    public AbstractSmartDevice(int locationId){
        this();
        this.locationId = locationId;
    }

    public AbstractSmartDevice(String name, int locationId) {
        this();
        this.name = name;
        this.locationId = locationId;
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
