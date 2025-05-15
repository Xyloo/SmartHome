package devices.decorator;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;
import util.SmartLogger;

//Tydzień 2, Wzorzec Decorator 3
public class SecurityCheckDecorator implements SmartDevice {
    private SmartDevice decoratedDevice;
    private SmartLogger logger = SmartLogger.getInstance();
    private Mediator mediator;
    private final double securityThreshold = 0.5;

    public SecurityCheckDecorator(SmartDevice device) {
        this.decoratedDevice = device;
    }

    // Simulated security check method
    private boolean performSecurityCheck() {
        logger.log(this,"Performing security check for " + decoratedDevice.getClass().getSimpleName() + "...");
        var random = Math.random();
        if (random < securityThreshold) {
            logger.log(this,"Security check passed.");
            return true;
        }
        logger.log(this,"Security check failed.");
        return false;
    }

    @Override
    public void turnOn() {
        if (performSecurityCheck()) {
            decoratedDevice.turnOn();
        } else {
            logger.log(this, "Security check failed. Cannot turn on the device.");
        }
    }

    @Override
    public void turnOff() {
        if (performSecurityCheck()) {
            decoratedDevice.turnOff();
        } else {
            logger.log(this,"Security check failed. Cannot turn off the device.");
        }
    }

    @Override
    public String getStatus() {
        return decoratedDevice.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        if(event.equals("SECURITY_CHECK_TURN_ON")){
            turnOn();
        }
    }
}
//Koniec Tydzień 2, Wzorzec Decorator 3