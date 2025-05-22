package devices.command;

import devices.impl.lighting.ColorLight;
import devices.impl.lighting.Light;
import devices.bridge.MobileRemoteControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandPatternTest {

    @Test
    void testMacroCommandExecutesAllCommands() {
        ColorLight light1 = new ColorLight("Light1");
        Light light2 = new Light();

        Command cmd1 = new TurnOnDeviceCommand(light1);
        Command cmd2 = new TurnOnDeviceCommand(light2);

        MacroCommand macro = new MacroCommand();
        macro.addCommand(cmd1);
        macro.addCommand(cmd2);

        assertFalse(light1.isOn(), "Light1 should be off initially");
        assertFalse(light2.isOn(), "Light2 should be off initially");

        macro.execute();

        assertTrue(light1.isOn(), "Light1 should be on after macro execution");
        assertTrue(light2.isOn(), "Light2 should be on after macro execution");
    }

    @Test
    void testMobileRemoteControlExecutesAssignedCommand() {
        ColorLight light = new ColorLight("LivingRoom");
        Command turnOn = new TurnOnDeviceCommand(light);

        MobileRemoteControl remote = new MobileRemoteControl(light);
        remote.setMainCommand(turnOn);

        assertFalse(light.isOn(), "Light should be off initially");

        remote.pressMainButton();

        assertTrue(light.isOn(), "Light should be on after remote control button press");
    }
}