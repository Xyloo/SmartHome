package devices.impl.lighting;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;

public class BasicLight implements SmartDevice
{
    private boolean isOn;
    private Mediator mediator;

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public void SetNightMode(){
        //mediator.
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    public String getStatus() {
        return isOn ? "ON" : "OFF";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {

    }
}
