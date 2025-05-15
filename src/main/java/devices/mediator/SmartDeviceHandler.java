package devices.mediator;

import devices.impl.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartDeviceHandler implements Mediator{
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        device.setMediator(this);
    }

    @Override
    public void notify(SmartDevice sender, String event) {
        for (SmartDevice device : devices) {
            device.handle(event);
        }
    }
}
