package devices.factory;

import devices.impl.security.sensors.MotionSensor;
import devices.impl.security.sensors.SecuritySensor;
import devices.impl.security.sensors.SensorTypeData;

import java.util.HashMap;
import java.util.Map;

public class SensorFactory {
    private static final Map<String, SecuritySensor> sensors = new HashMap<>();

    public static SecuritySensor getSensorType(SensorTypeData sensor) {
        if (sensor == null) {
            throw new IllegalArgumentException("Sensor cannot be null");
        }
        if (sensor.getType() == null || sensor.getModel() == null || sensor.getSettings() == null) {
            throw new IllegalArgumentException("Sensor type, model, and settings cannot be null");
        }

        String type = sensor.getType();
        String model = sensor.getModel();
        String settings = sensor.getSettings();

        String key = type + "_" + model + "_" + settings;
        SecuritySensor sensorType = sensors.get(key);

        if (sensorType == null) {
            switch (type.toLowerCase()) {
                case "motion":
                    sensorType = new MotionSensor(type, model, settings);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown sensor type: " + type);
            }
            sensors.put(key, sensorType);
            System.out.println("New sensor added: " + key);
        }
        return sensorType;
    }
}

