package devices.composite;

import devices.impl.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDeviceGroup implements SmartDevice {
    public final String id;
    protected List<SmartDevice> devices = new ArrayList<>();
    protected int locationId;

    public AbstractDeviceGroup() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    public AbstractDeviceGroup(int locationId) {
        this();
        this.locationId = locationId;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void removeDevice(SmartDevice device) {
        devices.remove(device);
    }

    @Override
    public void turnOn() {
        devices.forEach(SmartDevice::turnOn);
    }

    @Override
    public void turnOff() {
        devices.forEach(SmartDevice::turnOff);
    }

    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder();
        util.SmartLogger.getInstance ().log ("AbstractDeviceGroup -> id: " + id + " locationId: " + locationId);
        devices.forEach(device -> status.append(device.getStatus()).append("\n"));
        return status.toString();
    }
}
