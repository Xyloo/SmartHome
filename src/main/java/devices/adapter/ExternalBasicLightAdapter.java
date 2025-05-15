package devices.adapter;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.lighting.BasicLight;
import devices.mediator.Mediator;
import devices.visitor.SmartDeviceVisitor;
import util.SmartLogger;

//Tydzień 2, Wzorzec Adapter 1
public class ExternalBasicLightAdapter extends AbstractSmartDevice implements SmartDevice
{
    private final BasicLight legacyLight;
    private final SmartLogger logger = SmartLogger.getInstance();
    private Mediator mediator;

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

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        if(event.equals("EXTERNAL_LIGHT_ON")){
            turnOn();
        }
    }
    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}
//Koniec Tydzień 2, Adapter 1

