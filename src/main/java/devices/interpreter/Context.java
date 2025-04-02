package devices.interpreter;


import devices.impl.SmartDevice;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, SmartDevice> deviceMap = new HashMap<>();

    public void addDevice(String name, SmartDevice device) {
        deviceMap.put(name.toLowerCase(), device);
    }

    public SmartDevice getDevice(String name) {
        return deviceMap.get(name.toLowerCase());
    }
}