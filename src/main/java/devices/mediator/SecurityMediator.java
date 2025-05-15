package devices.mediator;

import devices.impl.SmartDevice;
import java.util.ArrayList;
import java.util.List;

public class SecurityMediator implements Mediator {
    private final List<SmartDevice> devices = new ArrayList<SmartDevice>();

    public void registerDevice(SmartDevice device) {
        devices.add(device);
    }

    @Override
    public void notify(SmartDevice sender, String event) {
        util.SmartLogger.getInstance().log("[SecurityMediator] Event received: " + event);
        for (SmartDevice device : devices) {
            if (device != sender) {
                device.handle(event);
            }
        }
    }
}
