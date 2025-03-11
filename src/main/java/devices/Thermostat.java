package devices;

public class Thermostat implements SmartDevice {
    private int temperature = 20; // default temperature

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
}

