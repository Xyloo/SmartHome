package devices.visitor;

import devices.adapter.ExternalBasicLightAdapter;
import devices.adapter.ExternalSecurityCameraAdapter;
import devices.adapter.ExternalThermostatAdapter;
import devices.impl.SmartPlug;
import devices.impl.Thermostat;
import devices.impl.doors.Door;
import devices.impl.lighting.ColorLight;
import devices.impl.lighting.Light;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;
import devices.state.lockings.SmartLock;

public interface SmartDeviceVisitor {
    void visit(ColorLight colorLight);
    void visit(Door door);
    void visit(ExternalBasicLightAdapter externalBasicLightAdapter);
    void visit(ExternalSecurityCameraAdapter externalSecurityCameraAdapter);
    void visit(ExternalThermostatAdapter externalThermostatAdapter);
    void visit(Light light);
    void visit(SecureWindow secureWindow);
    void visit(SecurityCamera securityCamera);
    void visit(SmartLock smartLock);
    void visit(SmartPlug smartPlug);
    void visit(Thermostat thermostat);
}
