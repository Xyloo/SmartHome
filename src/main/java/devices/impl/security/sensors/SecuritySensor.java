package devices.impl.security.sensors;

public interface SecuritySensor {
    void triggerAlarm(String location, boolean sendNotification);
    void test();
    void getStatus(boolean isActive, Integer batteryLevel, String location);
}
