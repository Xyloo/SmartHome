package devices.impl.security;

import java.util.Date;

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
