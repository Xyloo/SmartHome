package devices.state;

import devices.impl.SecurityAlarm;

public class ArmedState implements AlarmState {
    @Override
    public void arm(SecurityAlarm alarm) {
        System.out.println("Alarm is already armed.");
    }

    @Override
    public void disarm(SecurityAlarm alarm) {
        alarm.setState(new DisarmedState());
        System.out.println("Alarm disarmed.");
    }

    @Override
    public void trigger(SecurityAlarm alarm) {
        alarm.setState(new TriggeredState());
        System.out.println("Alarm triggered!");
    }

    @Override
    public String getStatus() {
        return "Armed";
    }
}

