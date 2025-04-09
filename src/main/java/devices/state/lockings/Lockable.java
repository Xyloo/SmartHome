package devices.state.lockings;

import devices.impl.SmartDevice;

public interface Lockable extends SmartDevice {
    void lock();
    void unlock();
}