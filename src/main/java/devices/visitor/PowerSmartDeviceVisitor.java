package devices.visitor;

import devices.impl.SmartPlug;

public interface PowerSmartDeviceVisitor {
    void visit(SmartPlug smartPlug);
}
