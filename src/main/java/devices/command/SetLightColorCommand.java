package devices.command;

import devices.impl.lighting.ColorLight;

// Tydzien 4, Wzorzec Command 2
public class SetLightColorCommand implements Command {

    ColorLight light;
    String color, previousColor;

    public SetLightColorCommand(ColorLight light, String color) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousColor = light.getColor();
        light.setColor(color);
    }

    @Override
    public void undo() {
        light.setColor(previousColor);
    }
}
// Koniec Tydzien 4, Wzorzec Command 2