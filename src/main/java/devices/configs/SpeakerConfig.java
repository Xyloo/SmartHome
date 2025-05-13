package devices.configs;

public class SpeakerConfig {
    private final String model;
    private final String manufacturer;
    private final boolean isVoiceAssistantCapable;

    public SpeakerConfig(String model, String manufacturer, boolean isVoiceAssistantCapable) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.isVoiceAssistantCapable = isVoiceAssistantCapable;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isVoiceAssistantCapable() {
        return isVoiceAssistantCapable;
    }
}
