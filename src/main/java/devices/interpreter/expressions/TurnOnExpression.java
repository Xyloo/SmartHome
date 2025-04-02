package devices.interpreter.expressions;

import devices.impl.SmartDevice;
import devices.interpreter.Context;
import devices.interpreter.Expression;

public class TurnOnExpression implements Expression {
    private final String deviceName;

    public TurnOnExpression(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void interpret(Context context) {
        SmartDevice device = context.getDevice(deviceName);
        if (device != null) {
            device.turnOn();
            util.SmartLogger.getInstance().log("[TurnOnExpression] Turned on " + deviceName);
        } else {
            util.SmartLogger.getInstance().log("[TurnOnExpression] Device not found: " + deviceName);
        }
    }
}
