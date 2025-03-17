package devices.impl.lighting;

import devices.impl.SmartDevice;

public interface LightingDevice extends SmartDevice {
    void setBrightness( int brightness );
    int getBrightness();
}
