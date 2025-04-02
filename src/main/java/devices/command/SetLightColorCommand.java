package devices.command;

import devices.impl.lighting.ColorLight;
import devices.impl.lighting.LightingDevice;

// Tydzien 4, Wzorzec Command 2
public class SetLightColorCommand implements Command {

    LightingDevice light;
    String color, previousColor;

    public SetLightColorCommand(LightingDevice light, String color) {
        this.light = light;
        this.color = color;
    }

    @Override
    public void execute() {
        if(light instanceof ColorLight) {
            ColorLight colorLight = (ColorLight) light;
            previousColor = colorLight.getColor();
            colorLight.setColor(color);
        }
    }

    @Override
    public void undo()
    {
        if(light instanceof ColorLight) {
            ColorLight colorLight = (ColorLight) light;
            colorLight.setColor(previousColor);
        }
    }
}
// Koniec Tydzien 4, Wzorzec Command 2