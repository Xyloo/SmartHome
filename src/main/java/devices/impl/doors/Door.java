package devices.impl.doors;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.security.lockingsystem.LockingSystemDevice;
import devices.mediator.Mediator;

public class Door extends AbstractSmartDevice implements SmartDevice, LockingSystemDevice {
    public static final String CONFIG_KEY = "DOOR";
    private boolean isLocked = false;
    private Mediator mediator;

    @Override
    public String getStatus() {
        return "Door [" + id + "] is " + (isOn ? "ON" : "OFF") + " isLocked: " + isLocked;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        util.SmartLogger.getInstance().log("Door handle: " + event);
        if(event.equals("activateSecurityMode")){
            close();
        }
        else if(event.equals("deactivateSecurityMode")){
            open();
        }
    }

    public void simulateIncorrectPassword() {
        util.SmartLogger.getInstance().log(this, "Incorrect password entered at door ");
        if (mediator != null) {
            mediator.notify(this, "activateSecurityMode");
        }
    }

    @Override
    public void open() {
        isLocked = false;
    }

    @Override
    public void close() {
        isLocked = false;
    }

    @Override
    public String getDescription() {
        return getStatus();
    }
}
