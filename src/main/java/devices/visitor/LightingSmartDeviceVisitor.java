package devices.visitor;

import devices.impl.lighting.ColorLight;
import devices.impl.lighting.Light;

public interface LightingSmartDeviceVisitor {
    void visit(ColorLight colorLight);
    void visit(Light light);
}

