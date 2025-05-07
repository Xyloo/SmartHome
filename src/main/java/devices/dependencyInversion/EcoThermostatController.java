package devices.dependencyInversion;

import devices.InterfaceSegregation.EnergySaver;

public class EcoThermostatController {
    private final EnergySaver ecoThermostat;

    public EcoThermostatController(EnergySaver ecoThermostat) {
        this.ecoThermostat = ecoThermostat;
    }
    public void enableThermostatEcoMode(){
        ecoThermostat.enableEcoMode();
    }
    public void disableThermostatEcoMode(){
        ecoThermostat.disableEcoMode();
    }
}
