package devices.state.lockings;

import devices.impl.AbstractSmartDevice;
import devices.mediator.Mediator;
import devices.visitor.SecuritySmartDeviceVisitor;
import devices.visitor.SmartDeviceVisitor;

public class SmartLock extends AbstractSmartDevice implements Lockable {
    private LockState state;
    public boolean isLocked = false;
    public SmartLock(String name, int locationId) {
        super(name, locationId);

        state = new UnlockedState();
        isLocked = state.getStatus().equals("Locked");
    }

    // Allow the state to be changed
    public void setState(LockState state) {
        this.state = state;
    }

    @Override
    public void lock() {
        state.lock(this);
        isLocked = true;
    }

    @Override
    public void unlock() {
        state.unlock(this);
        isLocked = false;
    }

    @Override
    public String getStatus() {
        return "SmartLock [" + getId() + "] is " + state.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {

    }

    @Override
    public void handle(String event) {

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