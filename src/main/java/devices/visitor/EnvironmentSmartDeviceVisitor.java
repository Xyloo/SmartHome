package devices.visitor;

import devices.InterfaceSegregation.EcoThermostat;
import devices.impl.Thermostat;

public interface EnvironmentSmartDeviceVisitor {
    void visit(Thermostat thermostat);
}
