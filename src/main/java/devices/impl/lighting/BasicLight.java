package devices.impl.lighting;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;

public class BasicLight implements SmartDevice
{
    private boolean on;
    private Mediator mediator;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }

    public void SetNightMode(){
        //mediator.
    }

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    public String getStatus() {
        return on ? "ON" : "OFF";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {

    }
}
