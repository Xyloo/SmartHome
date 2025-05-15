package devices.strategy;

import devices.impl.Thermostat;
import devices.impl.ThermostatConstants;

public class ComfortModeStrategy implements TemperatureControlStrategy {
    @Override
    public void adjustTemperature(Thermostat thermostat) {
        thermostat.setTemperature(ThermostatConstants.COMFORTABLE_TEMPERATURE);
        System.out.println("Comfort Mode: Thermostat set to " + ThermostatConstants.COMFORTABLE_TEMPERATURE + "°C for optimal comfort.");
    }
}

