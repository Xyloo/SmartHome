package devices.impl.security.sensors;

import devices.factory.SensorFactory;
import java.util.HashMap;
import java.util.Map;

public class SmartHomeSecuritySystem {
    private final Map<String, Sensor> sensors = new HashMap<>();

    public void installSensor(int batteryLevel, boolean isActive, String location,
                              String type, String settings, String model, boolean sendNotification) {
        SecuritySensor sensorType = SensorFactory.getSensorType(type, settings, model);
        Sensor sensor = new Sensor(batteryLevel, isActive, location, sensorType, sendNotification);
        sensors.put(location, sensor);
    }

    public void triggerAlarm(String location) {
        Sensor sensor = sensors.get(location);
        if (sensor != null) {
            sensor.trigger();
        }
    }

    public void testSensor(String location) {
        Sensor sensor = sensors.get(location);
        if (sensor != null) {
            sensor.test();
        }
    }

    public void getSensorStatus(String location) {
        Sensor sensor = sensors.get(location);
        if (sensor != null) {
            sensor.getStatus();
        }
    }
}