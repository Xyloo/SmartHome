package devices.strategy;

import devices.impl.LightBrightnessConstants;
import devices.impl.lighting.ColorLight;
import devices.impl.lighting.LightingDevice;
import devices.strategy.lighting.BrightnessStrategy;
import devices.strategy.lighting.EnergySavingStrategy;
import devices.strategy.lighting.FullBrightnessStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrightnessStrategyTest {

    @Test
    void testEnergySavingStrategySetsEcoBrightness() {
        LightingDevice light = new ColorLight("LightEco");
        BrightnessStrategy strategy = new EnergySavingStrategy();

        strategy.apply(light);

        assertEquals(LightBrightnessConstants.LIGHT_ECO, light.getBrightness());
    }

    @Test
    void testFullBrightnessStrategySetsFullBrightness() {
        LightingDevice light = new ColorLight("LightFull");
        BrightnessStrategy strategy = new FullBrightnessStrategy();

        strategy.apply(light);

        assertEquals(LightBrightnessConstants.LIGHT_BRIGHT, light.getBrightness());
    }
}