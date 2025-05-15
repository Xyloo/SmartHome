package devices.strategy.lighting;

import devices.impl.LightBrightnessConstants;
import devices.impl.lighting.LightingDevice;


//Tydzień 5, Wzorzec Strategy 3
public class EnergySavingStrategy implements BrightnessStrategy {
    @Override
    public void apply(LightingDevice light) {
        light.setBrightness(LightBrightnessConstants.LIGHT_ECO);
        System.out.println("Strategy: Set energy-saving brightness.");
    }
}
//Koniec Tydzień 5, Wzorzec Strategy 3