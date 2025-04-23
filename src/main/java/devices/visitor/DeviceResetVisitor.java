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

import java.awt.*;

public class DeviceResetVisitor implements SmartDeviceVisitor
{

    @Override
    public void visit(ColorLight colorLight) {
        colorLight.setColor("white");
    }

    @Override
    public void visit(Door door) {
        door.close();
    }

    @Override
    public void visit(ExternalBasicLightAdapter externalBasicLightAdapter) {
        externalBasicLightAdapter.turnOff();
    }

    @Override
    public void visit(ExternalSecurityCameraAdapter externalSecurityCameraAdapter) {
        externalSecurityCameraAdapter.turnOff();
        externalSecurityCameraAdapter.setAutoRecordingEnabled(false);
        externalSecurityCameraAdapter.setMotionDetectionEnabled(false);
    }

    @Override
    public void visit(ExternalThermostatAdapter externalThermostatAdapter) {
        externalThermostatAdapter.turnOff();
    }

    @Override
    public void visit(Light light) {
        light.turnOff();
        light.setBrightness(60);
    }

    @Override
    public void visit(SecureWindow secureWindow) {
        secureWindow.turnOff();
    }

    @Override
    public void visit(SecurityCamera securityCamera) {
        securityCamera.stopRecording();
        securityCamera.setAutoRecordingEnabled(false);
        securityCamera.setMotionDetectionEnabled(false);
        securityCamera.turnOff();
    }

    @Override
    public void visit(SmartLock smartLock) {
        smartLock.lock();
    }

    @Override
    public void visit(SmartPlug smartPlug) {
        smartPlug.turnOff();
    }

    @Override
    public void visit(Thermostat thermostat) {
        thermostat.adjustTemperature();
        thermostat.turnOff();
    }
}
