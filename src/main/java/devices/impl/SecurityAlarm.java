package devices.impl;

import notifications.NotificationGroup;

public class SecurityAlarm implements SmartDevice
{
    private boolean on;
    private final NotificationGroup notificationGroup;

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
}