package devices.impl;

import devices.mediator.Mediator;

public class Thermostat extends AbstractSmartDevice implements SmartDevice {
    private int temperature = 20; // default temperature
    private Mediator mediator;

    @Override
    public void turnOn() {
        super.turnOn();
        temperature = 20;
    }

    @Override
    public void turnOff() {
        super.turnOff();
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

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

