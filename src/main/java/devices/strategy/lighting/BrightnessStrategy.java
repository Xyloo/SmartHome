package devices.strategy.lighting;

import devices.impl.lighting.LightingDevice;

public interface BrightnessStrategy {
    void apply(LightingDevice light);
}
