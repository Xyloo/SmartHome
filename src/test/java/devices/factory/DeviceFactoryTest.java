package devices.factory;

import devices.impl.SmartDevice;
import devices.impl.Thermostat;
import devices.impl.lighting.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceFactoryTest {

    @Test
    void testCreateColorLightReturnsColorLight() {
        SmartDevice device = DeviceFactory.createDevice("light");

        assertNotNull(device, "Device should not be null");
        assertInstanceOf(Light.class, device, "Device should be an instance of ColorLight");
    }

    @Test
    void testCreateSecurityCameraReturnsCamera() {
        SmartDevice device = DeviceFactory.createDevice("thermostat");

        assertNotNull(device, "Device should not be null");
        assertInstanceOf(Thermostat.class, device, "Device should be an instance of SecurityCamera");
    }

    @Test
    void testCreateUnknownTypeThrows() {
        //DeviceFactory throws an IllegalArgumentException if type is unknown
        assertThrows(IllegalArgumentException.class, () -> {
            DeviceFactory.createDevice("UnknownType");
        }, "Expected IllegalArgumentException for unknown device type");
    }
}