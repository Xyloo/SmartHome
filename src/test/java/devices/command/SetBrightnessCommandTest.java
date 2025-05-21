package devices.command;

import devices.impl.lighting.LightingDevice;
import devices.mediator.Mediator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SetBrightnessCommandTest {
    private static class DummyLight implements LightingDevice {
        int brightness = 10;
        @Override public void setBrightness(int b) { brightness = b; }
        @Override public int getBrightness()        { return brightness; }
        @Override public void turnOn()               { }
        @Override public void turnOff()              { }
        @Override public String getStatus()          { return ""; }
        @Override public void setMediator(Mediator mediator) {}
        @Override public void handle(String e)       { }
    }

    @Test
    void executeSetsAndUndoRestores() {
        DummyLight light = new DummyLight();
        SetBrightnessCommand cmd = new SetBrightnessCommand(light, 50);

        assertEquals(10, light.getBrightness());

        cmd.execute();
        assertEquals(50, light.getBrightness(), "Expected brightness to equal 50");

        cmd.undo();
        assertEquals(10, light.getBrightness(), "Expected brightness to equal 10");
    }
}