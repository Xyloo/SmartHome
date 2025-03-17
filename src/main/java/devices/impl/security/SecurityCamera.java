package devices.impl.security;

import devices.impl.AbstractSmartDevice;
import devices.configs.SecurityCameraConfig;
import util.DeviceManager;

import java.util.UUID;

public class SecurityCamera extends AbstractSmartDevice implements SecurityCameraDevice {
    public static final String CONFIG_KEY = "SecurityCamera";
    private boolean isRecording;
    private boolean isMotionDetectionEnabled;
    private boolean isAutoRecordingEnabled;

    public SecurityCamera() {
        SecurityCameraConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, SecurityCameraConfig.class);
        isRecording = config.isRecording();

        util.SmartLogger.getInstance ().log ("TEST..............");
    }
    public SecurityCamera(int locationId){
        super(locationId);
    }

    //zmienic konstruktor ewentualnie oddzielna methoda wrzucajaca konfig oddzielnie
    // do kazdego konstrutkora???

    @Override
    public void turnOff(){
        stopRecording();
        super.turnOff();
    }

    @Override
    public String getStatus() {
        return "Security Camera " +
                "is " + (isRecording ? "recording" : "idle") +
                ", id = " + id +
                ", isRecording = " + isRecording +
                ", isMotionDetectionEnabled = " + isMotionDetectionEnabled +
                ", isAutoRecordingEnabled = " + isAutoRecordingEnabled;
    }

    @Override
    public void startRecording() {  isRecording = true; }

    @Override
    public void stopRecording() { isRecording = false; }

    @Override
    public void takeSnapshot() {
        util.SmartLogger.getInstance().log ("SecurityCamera " + id +"created snapshot: " + UUID.randomUUID());
    }

    @Override
    public void setMotionDetectionEnabled( boolean enabled ) { isMotionDetectionEnabled = enabled; }

    @Override
    public boolean isMotionDetectionEnabled() { return isMotionDetectionEnabled; }

    @Override
    public void setAutoRecordingEnabled( boolean enabled ) { isAutoRecordingEnabled = enabled; }

    @Override
    public boolean isAutoRecordingEnabled() { return isAutoRecordingEnabled; }
}

