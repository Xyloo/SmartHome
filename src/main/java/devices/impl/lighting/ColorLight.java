package devices.impl.lighting;

import java.awt.*;

public class ColorLight extends Light implements ColorLightingDevice {
    private String color;

    public ColorLight(String color) {
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        color = color.toLowerCase();
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getStatus(){
        return super.getStatus() + ", Color: " + color;
    }
}
