package util;

import devices.impl.SmartDevice;

@FunctionalInterface
public interface DeviceTransformer {
    String transform(SmartDevice device);
}

