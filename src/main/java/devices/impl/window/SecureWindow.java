package devices.impl.window;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.security.lockingsystem.Blind;
import devices.impl.security.lockingsystem.BlindType;
import devices.impl.security.lockingsystem.SmartBlind;
import devices.mediator.Mediator;

import javax.print.attribute.standard.Media;

public class SecureWindow extends AbstractSmartDevice implements SmartDevice {
    private final Blind blind;
    private boolean locked;
    private Mediator mediator;

    public SecureWindow(String name, int locationId) {
        super(name, locationId);
        this.blind = new Blind(new BlindType(name, "secure", ""), String.valueOf(locationId));
    }

    @Override
    public void turnOn() {
        blind.open();
    }

    @Override
    public void turnOff() {
        blind.close();
    }

    @Override
    public String getStatus() {
        return "SecureWindow [" + name + "] - Locked: " + locked;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("activateSecurityMode")){
            util.SmartLogger.getInstance().log("[SecureWindow] - closing blinds, locking window ");
            turnOff();
            locked = true;

        }
        else if(event.equals("deactivateSecurityMode")){
            util.SmartLogger.getInstance().log("[SecureWindow] - opening blinds, unlocking window ");
            locked = false;
            turnOn();
        }
    }
}
