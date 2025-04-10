package devices.template;

import devices.impl.lighting.LightingDevice;

public class EveningLightingRoutine extends DeviceRoutine {

    public EveningLightingRoutine(LightingDevice device) {
        super(device);
    }

    @Override
    protected void performAction() {
        logger.log(this, "Executing EveningLightingRoutine on " + device.getStatus());
        device.turnOn();
        ((LightingDevice) device).setBrightness(40);
    }
}
