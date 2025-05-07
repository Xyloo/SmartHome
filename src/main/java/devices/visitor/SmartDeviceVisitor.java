package devices.visitor;

public interface SmartDeviceVisitor extends
        SecuritySmartDeviceVisitor,
        LightingSmartDeviceVisitor,
        ExternalSmartDeviceVisitor,
        EnvironmentSmartDeviceVisitor,
        EcoThermostatVisitor,
        PowerSmartDeviceVisitor {
}

