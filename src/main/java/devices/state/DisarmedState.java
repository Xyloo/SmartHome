package devices.state;

import devices.impl.SecurityAlarm;

public class DisarmedState implements AlarmState {
    @Override
    public void arm(SecurityAlarm alarm) {
        alarm.setState(new ArmedState());
        System.out.println("Alarm is now armed.");
    }

    @Override
    public void disarm(SecurityAlarm alarm) {
        System.out.println("Alarm is already disarmed.");
    }

    @Override
    public void trigger(SecurityAlarm alarm) {
        System.out.println("Cannot trigger an alarm that is disarmed.");
    }

    @Override
    public String getStatus() {
        return "Disarmed";
    }
}

