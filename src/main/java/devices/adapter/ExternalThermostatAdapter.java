package devices.adapter;

import devices.impl.AbstractSmartDevice;
import devices.impl.SmartDevice;
import devices.impl.Thermostat;
import util.SmartLogger;

//Tydzień 2, Wzorzec Adapter 3
public class ExternalThermostatAdapter extends AbstractSmartDevice implements SmartDevice
{
    private final Thermostat legacyThermostat;
    private final SmartLogger logger = SmartLogger.getInstance();

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
}
//Koniec Tydzień 2, Wzorzec Adapter 1