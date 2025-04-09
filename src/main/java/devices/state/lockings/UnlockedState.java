package devices.state.lockings;

public class UnlockedState implements LockState {

    @Override
    public void lock(SmartLock lock) {
        System.out.println("Locking SmartLock...");
        lock.setState(new LockedState());
    }

    @Override
    public void unlock(SmartLock lock) {
        System.out.println("SmartLock is already unlocked.");
    }

    @Override
    public String getStatus() {
        return "Unlocked";
    }
}