package devices.impl.security.sensors;

public class SensorTypeData {
    private String type;
    private String model;
    private String settings;

    public SensorTypeData(String type, String model, String settings) {
        this.type = type;
        this.model = model;
        this.settings = settings;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getSettings() {
        return settings;
    }
}
