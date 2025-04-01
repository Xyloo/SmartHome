package devices.mediator;

import devices.impl.SmartDevice;

public interface Mediator {
    void notify(SmartDevice sender, String event);
}
