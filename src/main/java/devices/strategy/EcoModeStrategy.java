package devices.strategy;

import devices.impl.Thermostat;

public class EcoModeStrategy implements TemperatureControlStrategy {
    @Override
    public void adjustTemperature(Thermostat thermostat) {
        thermostat.setTemperature(18);
        System.out.println("Eco Mode: Thermostat set to 18°C for energy saving.");
    }
}
