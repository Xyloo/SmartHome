package devices.strategy;

import devices.impl.Thermostat;

public class ComfortModeStrategy implements TemperatureControlStrategy {
    @Override
    public void adjustTemperature(Thermostat thermostat) {
        thermostat.setTemperature(22);
        System.out.println("Comfort Mode: Thermostat set to 22°C for optimal comfort.");
    }
}

