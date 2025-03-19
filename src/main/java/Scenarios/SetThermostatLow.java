package Scenarios;

public class SetThermostatLow implements SmartAction {
    @Override
    public void execute() {
        System.out.println("Setting thermostat to 18°C.");
    }
}