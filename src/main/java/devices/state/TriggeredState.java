package devices.state;

import devices.impl.SecurityAlarm;

public class TriggeredState implements AlarmState {
    @Override
    public void arm(SecurityAlarm alarm) {
        System.out.println("Cannot arm an alarm that is already triggered.");
    }

    @Override
    public void disarm(SecurityAlarm alarm) {
        alarm.setState(new DisarmedState());
        System.out.println("Alarm has been reset to disarmed.");
    }

    @Override
    public void trigger(SecurityAlarm alarm) {
        System.out.println("Alarm is already triggered.");
    }

    @Override
    public String getStatus() {
        return "Triggered";
    }
}
