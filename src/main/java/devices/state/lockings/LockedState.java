package devices.state.lockings;

public class LockedState implements LockState {

    @Override
    public void lock(SmartLock lock) {
        System.out.println("SmartLock is already locked.");
    }

    @Override
    public void unlock(SmartLock lock) {
        System.out.println("Unlocking SmartLock...");
        lock.setState(new UnlockedState());
    }

    @Override
    public String getStatus() {
        return "Locked";
    }
}