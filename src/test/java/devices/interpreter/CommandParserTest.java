package devices.interpreter;

import devices.impl.SmartDevice;
import devices.impl.lighting.LightingDevice;
import devices.impl.speakers.SmartSpeaker;
import devices.impl.speakers.SpeakerType;
import devices.interpreter.expressions.SetBrightnessExpression;
import devices.interpreter.expressions.SetSpeakerVolumeExpression;
import devices.interpreter.expressions.TurnOnExpression;
import devices.mediator.Mediator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    private Context ctx;

    @BeforeEach
    void setUp() {
        ctx = new Context();
    }
    @Test
    void turnOnExpression_turnsOnDevice() {
        DummyDevice dev = new DummyDevice();
        ctx.addDevice("myDevice", dev);

        new TurnOnExpression("myDevice").interpret(ctx);
        assertTrue(dev.wasOn, "Device should have been turned on");
    }

    @Test
    void turnOnExpression_unknownDevice_noException() {
        assertDoesNotThrow(() ->
                new TurnOnExpression("noSuch").interpret(ctx)
        );
    }

    @Test
    void setBrightnessExpression_changesBrightness() {
        DummyLight light = new DummyLight();
        ctx.addDevice("lamp", light);

        new SetBrightnessExpression("lamp", 42).interpret(ctx);
        assertEquals(42, light.brightness,
                "Brightness should be updated to 42");
    }

    @Test
    void setBrightnessExpression_onWrongType_noEffect() {
        DummyDevice dev = new DummyDevice();
        ctx.addDevice("foo", dev);
        new SetBrightnessExpression("foo", 99).interpret(ctx);
        assertEquals(0, ((DummyDevice) ctx.getDevice("foo")).dummyField);
    }

    @Test
    void setSpeakerVolumeExpression_changesVolume() throws Exception {
        SmartSpeaker speaker = new SmartSpeaker(new SpeakerType("GO", "JBL", true), "Kitchen");
        ctx.addDevice("speaker", speaker);
        new SetSpeakerVolumeExpression("speaker", 100).interpret(ctx);
        assertEquals(100, speaker.getVolume(), "Volume should be updated to 100");

    }

    private static class DummyDevice implements SmartDevice {
        boolean wasOn = false;
        int dummyField = 0;
        @Override public void turnOn()  { wasOn = true; }
        @Override public void turnOff() { }
        @Override public String getStatus() { return ""; }
        @Override public void setMediator(Mediator mediator) {}
        @Override public void handle(String event) {}
    }

    private static class DummyLight implements LightingDevice {
        int brightness = 0;
        @Override public void setBrightness(int b) { brightness = b; }
        @Override public int getBrightness() { return brightness; }
        @Override public void turnOn()  {}
        @Override public void turnOff() {}
        @Override public String getStatus() { return ""; }
        @Override public void setMediator(Mediator mediator) {}
        @Override public void handle(String event) {}
    }
}