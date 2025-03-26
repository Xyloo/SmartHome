package devices.impl.speakers;

public class SpeakerType {
    private final String model;
    private final String manufacturer;
    private final boolean voiceAssistantCapable;

    public SpeakerType(String model, String manufacturer, boolean voiceAssistantCapable) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.voiceAssistantCapable = voiceAssistantCapable;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean getvoiceAssistantCapable() {
        return voiceAssistantCapable;
    }
}