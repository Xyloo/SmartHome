package devices.visitor;

import devices.adapter.ExternalBasicLightAdapter;
import devices.adapter.ExternalSecurityCameraAdapter;
import devices.adapter.ExternalThermostatAdapter;
import devices.impl.SmartDevice;
import devices.impl.SmartPlug;
import devices.impl.Thermostat;
import devices.impl.doors.Door;
import devices.impl.lighting.ColorLight;
import devices.impl.lighting.Light;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;
import devices.state.lockings.SmartLock;
import util.SmartLogger;

// Tydzien 6 Wzorzec Visitor 2
public class TurnOnVisitor implements SmartDeviceVisitor{
    private final SmartLogger logger = SmartLogger.getInstance();

    private void visitDevice(SmartDevice device)
    {
        device.turnOn();
        logger.log(device.getStatus());
    }

    @Override
    public void visit(ColorLight colorLight) {
        visitDevice(colorLight);
    }

    @Override
    public void visit(Door door) {
        visitDevice(door);
    }

    @Override
    public void visit(ExternalBasicLightAdapter externalBasicLightAdapter) {
        visitDevice(externalBasicLightAdapter);
    }

    @Override
    public void visit(ExternalSecurityCameraAdapter externalSecurityCameraAdapter) {
        visitDevice(externalSecurityCameraAdapter);
    }
    @Override
    public void visit(ExternalThermostatAdapter externalThermostatAdapter) {
        visitDevice(externalThermostatAdapter);
    }

    @Override
    public void visit(Light light) {
        visitDevice(light);
    }

    @Override
    public void visit(SecureWindow secureWindow) {
        visitDevice(secureWindow);
    }

    @Override
    public void visit(SecurityCamera securityCamera) {
        visitDevice(securityCamera);
    }

    @Override
    public void visit(SmartLock smartLock) {
        visitDevice(smartLock);
    }

    @Override
    public void visit(SmartPlug smartPlug) {
        visitDevice(smartPlug);
    }

    @Override
    public void visit(Thermostat thermostat) {
        visitDevice(thermostat);
    }
}
// Koniec Tydzien 6 Wzorzec Visitor 2