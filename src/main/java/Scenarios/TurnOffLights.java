package Scenarios;

public class TurnOffLights implements SmartAction{

    @Override
    public void execute() {
        System.out.println("Turning off all lights.");
    }
}
