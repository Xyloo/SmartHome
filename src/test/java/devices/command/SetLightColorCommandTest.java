package devices.command;

import devices.impl.lighting.ColorLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetLightColorCommandTest {
    @Test
    void executeSetsAndUndoRestoresColor() {
        ColorLight light = new ColorLight("green");
        SetLightColorCommand cmd = new SetLightColorCommand(light, "blue");

        assertEquals("green", light.getColor(), "Expected the light color to be green");

        cmd.execute();
        assertEquals("blue", light.getColor(), "Expected the light color to be blue");

        cmd.undo();
        assertEquals("green", light.getColor(), "Expected the light color to be green");
    }
}