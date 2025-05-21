package devices.visitor;

import devices.impl.doors.Door;
import devices.state.lockings.SmartLock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnableSecurityVisitorTest {

    private SecuritySmartDeviceVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new EnableSecurityVisitor();
    }

    @Test
    void testVisitSmartLockLocks() {
        SmartLock lock = new SmartLock("DOOR",1);
        String exceptedStatus = "SmartLock "  + "[" + lock.getId() + "]" +" is Locked";

        assertFalse(lock.isLocked, "SmartLock powinien być początkowo odblokowany");

        lock.acceptVisitor(visitor);
        assertTrue(lock.isLocked, "SmartLock powinien być zablokowany po wizycie");
        assertEquals(exceptedStatus, lock.getStatus());
    }

    @Test
    void testVisitDoorClose() {
        Door door = new Door();
        assertFalse(door.isLocked, "Door powinien być początkowo otwarty");

        door.acceptVisitor(visitor);

        assertFalse(door.isLocked, "Door powinien być zamknięty po wizycie");
    }
}
