package devices.command;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnOnDeviceCommandTest {
    private static class DummyDevice implements SmartDevice {
        boolean onCalled = false;
        boolean offCalled = false;
        @Override public void turnOn()                { onCalled = true; }
        @Override public void turnOff()               { offCalled = true; }
        @Override public String getStatus()           { return ""; }
        @Override public void setMediator(Mediator mediator) {}
        @Override public void handle(String event)    { }
    }

    @Test
    void executeAndUndoAlwaysTurnOff() {
        TurnOnDeviceCommandTest.DummyDevice dev = new TurnOnDeviceCommandTest.DummyDevice();
        TurnOnDeviceCommand cmd = new TurnOnDeviceCommand(dev);

        cmd.execute();
        assertTrue(dev.onCalled);
        cmd.undo();
        assertTrue(dev.offCalled);
    }
}