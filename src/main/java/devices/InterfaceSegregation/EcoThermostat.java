package devices.InterfaceSegregation;

import devices.impl.SmartDevice;
import devices.impl.ThermostatConstants;
import devices.mediator.Mediator;

public class EcoThermostat  implements SmartDevice, TemperatureControllable, EnergySaver{

    private int temperature = ThermostatConstants.DEFAULT_TEMPERATURE;
    private Mediator mediator;

    @Override
    public void turnOn() {
        temperature = ThermostatConstants.DEFAULT_TEMPERATURE;
    }

    @Override
    public void turnOff() {
        temperature = ThermostatConstants.THERMOSTAT_OFF;
    }

    @Override
    public String getStatus() {
        return (temperature == 0) ? "Thermostat is OFF" : "Thermostat is ON. Current temperature is " + temperature + " degrees";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("SET_TEMPERATURE_20")){
            setTemperature(ThermostatConstants.DEFAULT_TEMPERATURE);
        }
    }
    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void enableEcoMode() {
        System.out.println("Eco mode enabled!");
    }

    @Override
    public void disableEcoMode() {
        System.out.println("Eco mode disabled!");
    }
}
