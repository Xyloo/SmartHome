package devices.strategy.lighting;

import devices.impl.lighting.LightingDevice;

public class FullBrightnessStrategy implements BrightnessStrategy {
    @Override
    public void apply(LightingDevice light) {
        light.setBrightness(100);
        System.out.println("Strategy: Set full brightness.");
    }
}