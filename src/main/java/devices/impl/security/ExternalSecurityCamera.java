package devices.impl.security;

import java.util.UUID;

public class ExternalSecurityCamera implements ExternalSecurityCameraDevice {
    private String id;
    private boolean isRecording;
    private boolean isAutoRecordingEnabled;
    private boolean isMotionDetectionEnabled;

    public ExternalSecurityCamera() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public void toggleRecording() {
        isRecording = !isRecording;
    }

    @Override
    public void saveDataToExternalStorage() {
        //saving data
        util.SmartLogger.getInstance().log("[ExternalSecurityCamera] save data to external storage");
    }

    @Override
    public void toggleAutoRecording() {
        isAutoRecordingEnabled = !isAutoRecordingEnabled;
        util.SmartLogger.getInstance().log("[ExternalSecurityCamera] toggle auto recording: " + isAutoRecordingEnabled);
    }

    @Override
    public boolean isAutoRecording() {
        return isAutoRecordingEnabled;
    }

    @Override
    public boolean isRecording() {
        return isRecording;
    }

    @Override
    public boolean isMotionDetectionEnabled() {
        return isMotionDetectionEnabled;
    }

    @Override
    public void toggleMotionDetection() {
        isMotionDetectionEnabled = !isMotionDetectionEnabled;
        util.SmartLogger.getInstance().log("[ExternalSecurityCamera] toggleMotionDetection:" + isMotionDetectionEnabled);
    }

    @Override
    public String showDeviceState() {
        return "[ExternalSecurityCamera] [" + id + "]"
                + " isRecording=" + isRecording
                + ", isAutoRecordingEnabled=" + isAutoRecordingEnabled
                + ", isMotionDetectionEnabled=" + isMotionDetectionEnabled;
    }
}
