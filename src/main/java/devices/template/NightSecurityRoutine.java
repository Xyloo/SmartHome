package devices.template;

import devices.impl.security.SecurityCameraDevice;

public class NightSecurityRoutine extends DeviceRoutine {

    public NightSecurityRoutine(SecurityCameraDevice device) {
        super(device);
    }

    @Override
    protected void performAction() {
        logger.log(this, "Executing NightSecurityRoutine on " + device.getStatus());
        device.turnOn();
        ((SecurityCameraDevice) device).startRecording();
    }
}
