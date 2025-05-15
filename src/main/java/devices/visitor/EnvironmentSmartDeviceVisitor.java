package devices.visitor;

import devices.impl.Thermostat;

public interface EnvironmentSmartDeviceVisitor {
    void visit(Thermostat thermostat);
}
