package devices.impl.security.sensors;

import devices.factory.SensorFactory;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeSecuritySystem {
    private final Map<String, Sensor> sensors = new HashMap<>();

    public void installSensor(SensorCommonData sensorCommonData, SensorTypeData sensorTypeData) {
        SecuritySensor sensorType = SensorFactory.getSensorType(sensorTypeData);
        Sensor sensor = new Sensor(sensorCommonData, sensorType);
        sensors.put(sensorCommonData.location(), sensor);
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