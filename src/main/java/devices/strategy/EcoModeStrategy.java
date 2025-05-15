package devices.strategy;

import devices.impl.Thermostat;
import devices.impl.ThermostatConstants;

public class EcoModeStrategy implements TemperatureControlStrategy {
    @Override
    public void adjustTemperature(Thermostat thermostat) {
        thermostat.setTemperature(ThermostatConstants.ECO_TEMPERATURE);
        System.out.println("Eco Mode: Thermostat set to 18°C for energy saving.");
    }
}
