package devices.impl.security.lockingsystem;

public interface LockingSystemDevice {
    String getDescription();
    void open();
    void close();
}
