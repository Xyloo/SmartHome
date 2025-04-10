package devices.template;

import devices.impl.SmartDevice;
import util.SmartLogger;

public abstract class DeviceRoutine {
    protected SmartDevice device;
    protected final SmartLogger logger = SmartLogger.getInstance();

    public DeviceRoutine(SmartDevice device) {
        this.device = device;
    }

    public final void executeRoutine() {
        preRoutine();
        performAction();
        postRoutine();
    }

    protected void preRoutine() {
        logger.log(this, "Preparing routine for device: " + device.getStatus());
    }

    protected abstract void performAction();

    protected void postRoutine() {
        logger.log(this, "Completing routine for device: " + device.getStatus());
    }
}
