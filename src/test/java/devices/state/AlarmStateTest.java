package devices.state;

import devices.impl.SecurityAlarm;
import notifications.NotificationGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmStateTest {

    private SecurityAlarm alarm;
    private NotificationGroup notificationGroup;

    @BeforeEach
    void setUp() {
        notificationGroup = new NotificationGroup();
        alarm = new SecurityAlarm(notificationGroup);
    }

    @Test
    void testTriggerInDisarmedStatePrintsExpectedMessage() {
        alarm.setState(new DisarmedState());

        assertEquals("Security alarm is ON and is currently Disarmed", alarm.getStatus(), "Initial state should be Disarmed");

        alarm.trigger();  // Should not change state
        assertEquals("Security alarm is ON and is currently Disarmed", alarm.getStatus(), "Trigger should not change state in Disarmed");
    }

    @Test
    void testArmInDisarmedStateTransitionsToArmedState() {
        alarm.setState(new DisarmedState());

        alarm.arm();  // Should change to ArmedState

        assertEquals("Security alarm is ON and is currently Armed", alarm.getStatus(), "Alarm should be in Armed state after arming");
    }
}