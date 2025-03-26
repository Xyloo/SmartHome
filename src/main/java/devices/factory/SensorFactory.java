package devices.factory;

import devices.impl.security.sensors.MotionSensor;
import devices.impl.security.sensors.SecuritySensor;
import java.util.HashMap;
import java.util.Map;

public class SensorFactory {
    private static final Map<String, SecuritySensor> sensors = new HashMap<>();

    public static SecuritySensor getSensorType(String type, String settings, String model) {
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