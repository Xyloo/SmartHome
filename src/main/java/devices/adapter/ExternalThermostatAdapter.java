package devices.adapter;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.Thermostat;
import devices.mediator.Mediator;
import util.SmartLogger;

//Tydzień 2, Wzorzec Adapter 3
public class ExternalThermostatAdapter extends AbstractSmartDevice implements SmartDevice
{
    private final Thermostat legacyThermostat;
    private final SmartLogger logger = SmartLogger.getInstance();
    private Mediator mediator;

    public ExternalThermostatAdapter(Thermostat legacyThermostat) {
        this.legacyThermostat = legacyThermostat;
    }

    @Override
    public void turnOn() {
        logger.log(this, "Complicated logic to turn on the thermostat");
        legacyThermostat.turnOn();
    }

    @Override
    public void turnOff() {
        logger.log(this,"Complicated logic to turn off the thermostat");
        legacyThermostat.turnOff();
    }

    @Override
    public String getStatus() {
        return "External Thermostat is " + legacyThermostat.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("EXTERNAL_THERMOSTAT_ON")){
            turnOn();
        }
    }
}
//Koniec Tydzień 2, Wzorzec Adapter 1