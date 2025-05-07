package devices.impl.security;

import devices.impl.SmartDevice;
import devices.impl.security.Interfaces.AutoRecordable;
import devices.impl.security.Interfaces.MotionDetectable;
import devices.impl.security.Interfaces.Recordable;

public interface SecurityCameraDevice extends SmartDevice, Recordable, MotionDetectable, AutoRecordable {
    void takeSnapshot();
}
