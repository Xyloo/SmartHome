package devices.strategy;

import devices.impl.Thermostat;
import devices.impl.ThermostatConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComfortModeStrategyTest {

    @Test
    void testComfortModeStrategySetsCorrectTemperature() {
        Thermostat thermostat = new Thermostat();
        ComfortModeStrategy strategy = new ComfortModeStrategy();

        thermostat.setStrategy(strategy);
        thermostat.adjustTemperature();

        assertEquals(ThermostatConstants.COMFORTABLE_TEMPERATURE, thermostat.getTemperature(), "Comfort mode should set target temperature to 22.0");
    }
}