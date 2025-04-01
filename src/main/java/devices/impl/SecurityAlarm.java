package devices.impl;

import devices.mediator.Mediator;
import notifications.NotificationGroup;

public class SecurityAlarm implements SmartDevice
{
    private boolean on;
    private final NotificationGroup notificationGroup;
    private Mediator mediator;

    public SecurityAlarm(NotificationGroup notificationGroup)
    {
        this.notificationGroup = notificationGroup;
    }

    @Override
    public void turnOn() {
        on = true;
        notificationGroup.send("Security alarm was just turned on");
    }

    @Override
    public void turnOff() {
        on = false;
        notificationGroup.send("Security alarm was just turned off");
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
        if(event.equals("ALARM_TURN_ON")){
            turnOn();
        }
    }
}