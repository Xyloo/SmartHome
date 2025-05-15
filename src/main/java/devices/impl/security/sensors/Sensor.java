package devices.impl.security.sensors;

// część unikalna każdego czujnika
public class Sensor {

    private final int batteryLevel;
    private final boolean isActive;
    private final String location;
    private final boolean sendNotification;
    private final SecuritySensor type;

    public Sensor(int batteryLevel, boolean isActive, String location, SecuritySensor type, boolean sendNotification) {
        this.batteryLevel = batteryLevel;
        this.isActive = isActive;
        this.location = location;
        this.type = type;
        this.sendNotification = sendNotification;
    }

    public Sensor(SensorCommonData sensorCommonData, SecuritySensor type) {
        this(sensorCommonData.batteryLevel(), sensorCommonData.isActive(), sensorCommonData.location(), type, sensorCommonData.sendNotification());
    }
    public void trigger(){
        type.triggerAlarm(location,sendNotification);
    }
    public void getStatus(){
        type.getStatus(isActive,batteryLevel,location);
    }
    public void test(){
        type.test();
    }
}
