package devices.impl;

import devices.mediator.Mediator;
import devices.state.AlarmState;
import devices.state.DisarmedState;
import notifications.NotificationGroup;

// Tydzień 5, Wzorzec State 1
public class SecurityAlarm implements SmartDevice
{
    private boolean isOn = true;
    private final NotificationGroup notificationGroup;
    private Mediator mediator;
    private AlarmState state;

    public SecurityAlarm(NotificationGroup notificationGroup)
    {
        this.notificationGroup = notificationGroup;
        this.state = new DisarmedState();
    }

    @Override
    public void turnOn() {
        isOn = true;
        notificationGroup.send("Security alarm was just turned on");
        arm();
    }

    @Override
    public void turnOff() {
        isOn = false;
        notificationGroup.send("Security alarm was just turned off");
        disarm();
    }

    public String getStatus() {
        return "Security alarm is " + (isOn ? "ON" : "OFF") + " and is currently " + state.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        if(event.equals("ALARM_TURN_ON")){
            turnOn();
        }
    }

    public void arm() {
        state.arm(this);
    }

    public void disarm() {
        state.disarm(this);
    }

    public void trigger() {
        state.trigger(this);
    }

    public void setState(AlarmState state) {
        this.state = state;
    }
}
// Koniec Tydzień 5, Wzorzec State 1