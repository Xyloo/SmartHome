package util;

import devices.impl.SmartDevice;

@FunctionalInterface
public interface DeviceAction {
    void perform(SmartDevice device);
}
