package devices.visitor;

import devices.impl.doors.Door;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;
import devices.state.lockings.SmartLock;
import util.SmartLogger;

public class EnableSecurityVisitor implements SecuritySmartDeviceVisitor {

    private final SmartLogger logger = SmartLogger.getInstance();

    @Override
    public void visit(SmartLock smartLock) {
        smartLock.lock();
        logger.log("SmartLock secured: " + smartLock.getStatus());
    }

    @Override
    public void visit(Door door) {
        door.close();
        logger.log("Door locked: " + door.getStatus());
    }

    @Override
    public void visit(SecurityCamera securityCamera) {
        securityCamera.startRecording();
        logger.log("Security camera activated: " + securityCamera.getStatus());
    }

    @Override
    public void visit(SecureWindow secureWindow) {
        secureWindow.lock();
        logger.log("Secure window locked: " + secureWindow.getStatus());
    }
}
