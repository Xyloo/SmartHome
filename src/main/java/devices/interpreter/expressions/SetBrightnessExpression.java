package devices.interpreter.expressions;

import devices.impl.SmartDevice;
import devices.impl.lighting.LightingDevice;
import devices.interpreter.Context;
import devices.interpreter.Expression;

public class SetBrightnessExpression implements Expression {
    private final String deviceName;
    private final int brightness;

    public SetBrightnessExpression(String deviceName, int brightness) {
        this.deviceName = deviceName;
        this.brightness = brightness;
    }

    @Override
    public void interpret( Context context) {
        SmartDevice device = context.getDevice(deviceName);
        if (device != null && device instanceof LightingDevice) {
            ((LightingDevice) device).setBrightness(brightness);
            util.SmartLogger.getInstance().log ("[SetBrightnessExpression] Setting brightness to " + brightness);
            }
        else {
            util.SmartLogger.getInstance().log ("[SetBrightnessExpression] Device not found or not a lighting device.");
        }
    }
}