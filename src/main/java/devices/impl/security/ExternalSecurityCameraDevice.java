package devices.impl.security;

public interface ExternalSecurityCameraDevice {
    void toggleRecording();
    void saveDataToExternalStorage();
    void toggleAutoRecording();
    boolean isAutoRecording();
    boolean isRecording();
    boolean isMotionDetectionEnabled();
    void toggleMotionDetection();
    String showDeviceState();
}
