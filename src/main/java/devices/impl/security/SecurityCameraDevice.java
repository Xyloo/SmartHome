package devices.impl.security;

import devices.impl.SmartDevice;

public interface SecurityCameraDevice extends SmartDevice {
    void startRecording();
    void stopRecording();
    void takeSnapshot();
    void setMotionDetectionEnabled(boolean enabled);
    boolean isMotionDetectionEnabled();
    void setAutoRecordingEnabled(boolean enabled);
    boolean isAutoRecordingEnabled();
}
