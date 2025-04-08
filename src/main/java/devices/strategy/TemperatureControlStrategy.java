package devices.strategy;

import devices.impl.Thermostat;

public interface TemperatureControlStrategy {
    void adjustTemperature(Thermostat thermostat);
}

