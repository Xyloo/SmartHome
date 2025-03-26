package devices.proxy;

public class SecurityCameraLibrary implements Camera {
    private byte[] videoData;

    @Override
    public void startRecording() {
        System.out.println("Recording started...");
        videoData = new byte[1024];
    }

    @Override
    public void stopRecording() {
        System.out.println("Recording stopped.");
    }

    @Override
    public byte[] getVideo() {
        return videoData;
    }
}