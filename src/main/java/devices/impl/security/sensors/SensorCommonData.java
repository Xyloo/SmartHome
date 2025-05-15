package devices.impl.security.sensors;

public record SensorCommonData(
        int batteryLevel,
        boolean isActive,
        String location,
        boolean sendNotification
){}
