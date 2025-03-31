package devices.command;

import devices.impl.lighting.LightingDevice;

// Tydzien 4, Wzorzec Command 2
public class SetBrightnessCommand implements Command {
    private LightingDevice lightingDevice;
    private int brightness, prevBrightness;

    public SetBrightnessCommand(LightingDevice device, int brightness) {
        this.brightness = brightness;
        this.lightingDevice = device;
    }

    @Override
    public void execute() {
        prevBrightness = lightingDevice.getBrightness();
        lightingDevice.setBrightness(brightness);
    }

    @Override
    public void undo() {
        lightingDevice.setBrightness(prevBrightness);
    }
}
// Koniec Tydzien 4, Wzorzec Command 2