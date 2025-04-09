package devices.state.lockings;

public interface LockState {
    void lock(SmartLock lock);
    void unlock(SmartLock lock);
    String getStatus();
}