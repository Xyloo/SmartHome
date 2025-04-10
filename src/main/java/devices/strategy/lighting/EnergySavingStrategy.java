package devices.strategy.lighting;

import devices.impl.lighting.LightingDevice;

public class EnergySavingStrategy implements BrightnessStrategy {
    @Override
    public void apply(LightingDevice light) {
        light.setBrightness(30);
        System.out.println("Strategy: Set energy-saving brightness.");
    }
}