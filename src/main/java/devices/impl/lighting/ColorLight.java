package devices.impl.lighting;

import devices.visitor.SmartDeviceVisitor;


public class ColorLight extends Light implements ColorLightingDevice {
    private String lightColor;

    public ColorLight(String color) {
        super();
        this.lightColor = color;
    }

    @Override
    public void setColor(String color) {
        this.lightColor = color.toLowerCase();
    }

    @Override
    public String getColor() {
        return lightColor;
    }

    @Override
    public String getStatus(){
        return super.getStatus() + ", Color: " + lightColor;
    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}
