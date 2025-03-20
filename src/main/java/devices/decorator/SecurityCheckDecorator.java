package devices.decorator;

import devices.impl.SmartDevice;
import util.SmartLogger;

//Tydzień 2, Wzorzec Decorator 3
public class SecurityCheckDecorator implements SmartDevice {
    private SmartDevice decoratedDevice;
    private SmartLogger logger = SmartLogger.getInstance();

    public SecurityCheckDecorator(SmartDevice device) {
        this.decoratedDevice = device;
    }

    // Simulated security check method
    private boolean performSecurityCheck() {
        logger.log(this,"Performing security check for " + decoratedDevice.getClass().getSimpleName() + "...");
        //placeholder for actual security check logic
        var random = Math.random();
        if (random < 0.5) {
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
}
//Koniec Tydzień 2, Wzorzec Decorator 3