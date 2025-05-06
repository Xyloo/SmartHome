package devices.visitor;

import devices.impl.doors.Door;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;
import devices.state.lockings.SmartLock;

public interface SecuritySmartDeviceVisitor {
    void visit(SmartLock smartLock);
    void visit(Door door);
    void visit(SecurityCamera securityCamera);
    void visit(SecureWindow secureWindow);
}

