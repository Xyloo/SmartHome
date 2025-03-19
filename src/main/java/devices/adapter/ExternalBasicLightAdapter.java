package devices.adapter;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.lighting.BasicLight;
import util.SmartLogger;

public class ExternalBasicLightAdapter extends AbstractSmartDevice implements SmartDevice
{
    private final BasicLight legacyLight;
    private final SmartLogger logger = SmartLogger.getInstance();

    public ExternalBasicLightAdapter(BasicLight legacyLight) {
        this.legacyLight = legacyLight;
    }

    @Override
    public void turnOn() {
        logger.log(this,"Complicated logic to turn on the light");
        legacyLight.switchOn();
    }

    @Override
    public void turnOff() {
        logger.log(this,"Complicated logic to turn off the light");
        legacyLight.switchOff();
    }

    @Override
    public String getStatus() {
        return "External Basic Light is " + legacyLight.getStatus();
    }
}

