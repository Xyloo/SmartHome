package devices.strategy.lighting;

import devices.impl.lighting.LightingDevice;

//Tydzień 5, Wzorzec Strategy 3
public class FullBrightnessStrategy implements BrightnessStrategy {
    @Override
    public void apply(LightingDevice light) {
        light.setBrightness(100);
        System.out.println("Strategy: Set full brightness.");
    }
}
//Koniec Tydzień 5, Wzorzec Strategy 3