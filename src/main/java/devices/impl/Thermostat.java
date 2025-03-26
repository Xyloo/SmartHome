package devices.impl;

public class Thermostat extends AbstractSmartDevice implements SmartDevice {
    private int temperature = 20; // default temperature

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

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

