package devices.state;

import devices.impl.SecurityAlarm;

public interface AlarmState {
    void arm(SecurityAlarm alarm);
    void disarm(SecurityAlarm alarm);
    void trigger(SecurityAlarm alarm);
    String getStatus();
}
