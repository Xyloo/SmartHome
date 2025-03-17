package devices.impl.security;

public interface SecurityCameraDevice {
    void startRecording();
    void stopRecording();
    void takeSnapshot();
    void setMotionDetectionEnabled(boolean enabled);
    boolean isMotionDetectionEnabled();
    void setAutoRecordingEnabled(boolean enabled);
    boolean isAutoRecordingEnabled();
}
