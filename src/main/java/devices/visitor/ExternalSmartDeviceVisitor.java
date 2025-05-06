package devices.visitor;

import devices.adapter.ExternalBasicLightAdapter;
import devices.adapter.ExternalSecurityCameraAdapter;
import devices.adapter.ExternalThermostatAdapter;

public interface ExternalSmartDeviceVisitor {
    void visit(ExternalBasicLightAdapter externalBasicLightAdapter);
    void visit(ExternalSecurityCameraAdapter externalSecurityCameraAdapter);
    void visit(ExternalThermostatAdapter externalThermostatAdapter);
}

