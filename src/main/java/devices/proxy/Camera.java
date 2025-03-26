package devices.proxy;

// wspólny interfejs dla SecurityCameraLibrary oraz CameraProxy
public interface Camera {
    void startRecording();
    void stopRecording();
    byte[] getVideo();
}