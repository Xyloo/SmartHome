package devices.decorator;

import devices.impl.security.SecurityCameraDevice;
import devices.mediator.Mediator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityCameraDecoratorTest {
    private SecurityCameraDecorator decorator;
    private StubCameraDevice stub;

    @BeforeEach
    void setUp() {
        stub = new StubCameraDevice();
        decorator = new SecurityCameraDecorator(stub);
    }

    @Test
    void startRecording_ForwardsToDecorated() {
        decorator.startRecording();
        assertTrue(stub.startCalled, "startRecording invoked");
    }

    @Test
    void defaultFeatureFlags_AreDisabled() {
        assertFalse(decorator.isMotionDetectionEnabled(), "Motion detection disabled");
        assertFalse(decorator.isAutoRecordingEnabled(), "Auto recording disabled");
    }

    @Test
    void handleSecurityCameraOn_EventTriggersTurnOn() {
        decorator.handle("SECURITY_CAMERA_ON");
        assertTrue(stub.turnOnCalled, "turnOn invoked on event");
    }

    private static class StubCameraDevice implements SecurityCameraDevice {
        boolean startCalled = false;
        boolean stopCalled = false;
        boolean snapshotCalled = false;
        boolean motionEnabled = true;
        boolean autoEnabled = true;
        boolean turnOnCalled = false;
        boolean turnOffCalled = false;

        @Override
        public void startRecording() { startCalled = true; }

        @Override
        public void stopRecording() { stopCalled = true; }

        @Override
        public void takeSnapshot() { snapshotCalled = true; }

        @Override
        public void setMotionDetectionEnabled(boolean enabled) { motionEnabled = enabled; }

        @Override
        public boolean isMotionDetectionEnabled() { return motionEnabled; }

        @Override
        public void setAutoRecordingEnabled(boolean enabled) { autoEnabled = enabled; }

        @Override
        public boolean isAutoRecordingEnabled() { return autoEnabled; }

        @Override
        public void turnOn() { turnOnCalled = true; }

        @Override
        public void turnOff() { turnOffCalled = true; }

        @Override
        public String getStatus() { return "OK"; }

        @Override
        public void setMediator(Mediator mediator) {  }

        @Override
        public void handle(String event) {}
    }
}
