package devices.state.lockings;

import devices.impl.AbstractSmartDevice;
import devices.mediator.Mediator;
import devices.visitor.SmartDeviceVisitor;

public class SmartLock extends AbstractSmartDevice implements Lockable {
    private LockState state;

    public SmartLock(String name, int locationId) {
        super(name, locationId);
        // Default state is Locked.
        state = new LockedState();
    }

    // Allow the state to be changed
    public void setState(LockState state) {
        this.state = state;
    }

    @Override
    public void lock() {
        state.lock(this);
    }

    @Override
    public void unlock() {
        state.unlock(this);
    }

    @Override
    public String getStatus() {
        return "SmartLock [" + getId() + "] is " + state.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {

    }

    @Override
    public void Handle(String event) {

    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}