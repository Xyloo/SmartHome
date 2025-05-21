package devices.impl;

import devices.impl.lighting.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    @Test
    void testDefaultStateIsOff() {
        Light light = new Light();
        assertFalse(light.isOn, "Nowe światło powinno być wyłączone");
    }

    @Test
    void testTurnOnAndStatus() {
        Light light = new Light();
        light.turnOn();
        assertTrue(light.isOn, "Po turnOn() światło powinno być włączone");
    }

    @Test
    void testTurnOffAfterOn() {
        Light light = new Light();
        light.turnOn();
        light.turnOff();
        assertFalse(light.isOn, "Po turnOff() światło powinno być wyłączone");
    }
}
