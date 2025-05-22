package devices.impl.window;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.security.lockingsystem.Blind;
import devices.impl.security.lockingsystem.BlindType;
import devices.mediator.Mediator;
import devices.visitor.SecuritySmartDeviceVisitor;
import devices.visitor.SmartDeviceVisitor;

public class SecureWindow extends AbstractSmartDevice implements SmartDevice {
    private final Blind blind;

    public boolean isLocked()
    {
        return locked;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    private boolean locked;
    private Mediator mediator;

    public SecureWindow(String name, int locationId) {
        super(name, locationId);
        this.blind = new Blind(new BlindType(name, "secure", ""), String.valueOf(locationId));
    }

    @Override
    public void turnOn() {
        blind.open();
    }

    @Override
    public void turnOff() {
        blind.close();
    }

    @Override
    public String getStatus() {
        return "SecureWindow [" + name + "] - Locked: " + locked;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void lock() {
        locked = true;
        blind.close();
        util.SmartLogger.getInstance().log("[SecureWindow] - Window locked");
    }

    public void unlock() {
        locked = false;
        blind.open();
        util.SmartLogger.getInstance().log("[SecureWindow] - Window unlocked");
    }

    @Override
    public void handle(String event) {
        if(event.equals("activateSecurityMode")){
            util.SmartLogger.getInstance().log("[SecureWindow] - closing blinds, locking window ");
            turnOff();
            locked = true;

        }
        else if(event.equals("deactivateSecurityMode")){
            util.SmartLogger.getInstance().log("[SecureWindow] - opening blinds, unlocking window ");
            locked = false;
            turnOn();
        }
    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }

    public void acceptVisitor(SecuritySmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}
