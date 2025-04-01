package devices.impl;

import devices.mediator.Mediator;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
    void setMediator(Mediator mediator);
    void Handle(String event);
}

