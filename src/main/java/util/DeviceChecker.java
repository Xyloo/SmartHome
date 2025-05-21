package util;

import devices.impl.SmartDevice;

@FunctionalInterface
public interface DeviceChecker {
    boolean check(SmartDevice device);
}

