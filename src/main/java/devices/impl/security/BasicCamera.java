package devices.impl.security;

import devices.impl.AbstractSmartDevice;
import devices.impl.security.Interfaces.AutoRecordable;
import devices.impl.security.Interfaces.Recordable;
import devices.mediator.Mediator;
import devices.visitor.SmartDeviceVisitor;

public class BasicCamera extends AbstractSmartDevice implements Recordable, AutoRecordable {
    public static final String CONFIG_KEY = "BasicCamera";
    private boolean isRecording;
    private boolean isAutoRecording;
    private Mediator mediator;

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        //visitor.visit(this);
    }

    @Override
    public String getStatus() {

        return "Basic Camera " +
                "is " + (isRecording ? "recording" : "idle") +
                ", id = " + id +
                ", isRecording = " + isRecording;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        util.SmartLogger.getInstance().log("BasicCamera: handle " + event);
    }

    @Override
    public void startRecording() {

        if(isRecording){
            util.SmartLogger.getInstance().log("BasicCamera: camera already recording");
        }
        else{
            isRecording = true;
        }
    }

    @Override
    public void stopRecording() {
        if(isRecording){
            isRecording = false;
        }
        else{
            util.SmartLogger.getInstance().log("BasicCamera: camera already stopped");
        }
    }

    @Override
    public  void setAutoRecordingEnabled(boolean enabled) {
        isAutoRecording = enabled;
    }

    @Override
    public boolean isAutoRecordingEnabled() {
        return false;
    }
}
