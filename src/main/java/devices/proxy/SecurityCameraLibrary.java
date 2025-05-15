package devices.proxy;

public class SecurityCameraLibrary implements Camera {
    private byte[] videoData;
    private String resolution;
    private String delay;
    private String savingSettings;
    private final int VIDEO_SIZE = 1024;

    @Override
    public void startRecording() {
        System.out.println("Recording started...");
        videoData = new byte[VIDEO_SIZE];
    }

    @Override
    public void stopRecording() {
        System.out.println("Recording stopped.");
    }

    @Override
    public byte[] getVideo() {
        return videoData;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setSavingSettings(String savingSettings) {
        this.savingSettings = savingSettings;
    }
}