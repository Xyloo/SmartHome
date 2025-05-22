package devices.visitor;

import devices.impl.doors.Door;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;
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

    @Test
    void testVisitSecurityCameraStartsRecording() {
        SecurityCamera camera = new SecurityCamera(1);

        assertFalse(camera.isRecording(), "Camera should initially not be recording");

        camera.acceptVisitor(visitor);

        assertTrue(camera.isRecording(), "Camera should start recording after visitor");
        assertTrue(camera.getStatus().startsWith("Security Camera is recording"));
    }

    @Test
    void testVisitSecureWindowLocks() {
        SecureWindow window = new SecureWindow("WINDOW1", 2);

        assertFalse(window.isLocked(), "Window should initially be unlocked");

        window.acceptVisitor(visitor);

        assertTrue(window.isLocked(), "Window should be locked after visitor");
        assertEquals("SecureWindow [WINDOW1] - Locked: true", window.getStatus());
    }
}
