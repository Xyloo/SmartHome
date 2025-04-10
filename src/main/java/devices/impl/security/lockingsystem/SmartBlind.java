package devices.impl.security.lockingsystem;

public interface SmartBlind {
    void info();
    void open();
    void setState(int coveringLevel, String mode);
    void close();
}
