package devices.impl.lighting;

import devices.visitor.SmartDeviceVisitor;


public class ColorLight extends Light implements ColorLightingDevice {
    private String color;

    public ColorLight(String color) {
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color.toLowerCase();
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getStatus(){
        return super.getStatus() + ", Color: " + color;
    }

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}
