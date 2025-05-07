package devices.InterfaceSegregation;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;

public class EcoThermostat  implements SmartDevice, TemperatureControllable, EnergySaver{
    private int temperature = 20;
    private Mediator mediator;

    @Override
    public void turnOn() {
        temperature = 20;
    }

    @Override
    public void turnOff() {
        temperature = 0;
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
            setTemperature(20);
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
