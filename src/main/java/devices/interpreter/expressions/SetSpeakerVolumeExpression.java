package devices.interpreter.expressions;

import devices.impl.SmartDevice;
import devices.impl.speakers.SmartSpeaker;
import devices.interpreter.Context;
import devices.interpreter.Expression;

public class SetSpeakerVolumeExpression  implements Expression {
    private final String location;
    private final int volume;

    public SetSpeakerVolumeExpression(String location, int volume) {
        this.volume = volume;
        this.location = location;
    }

    @Override
    public void interpret( Context context) {
        SmartDevice speaker = context.getDevice(location);
        if (speaker instanceof SmartSpeaker) {
            ((SmartSpeaker) speaker).setVolume(volume);
            util.SmartLogger.getInstance().log ("[SetSpeakerVolumeExpression] Setting volume to " + volume);
        }
        else {
            util.SmartLogger.getInstance().log ("[SetSpeakerVolumeExpression] Device not found or not a smart speaker.");
        }
    }
}


