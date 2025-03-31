package devices.impl.lighting;

public interface ColorLightingDevice extends LightingDevice {
    void setColor(String color);
    String getColor();
}

