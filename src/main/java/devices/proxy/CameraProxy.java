package devices.proxy;

// Tydzień 3, Wzorzec Proxy 1
public class CameraProxy implements Camera {
    private final SecurityCameraLibrary camera;
    private final CloudStorage cloudStorage;

    public CameraProxy() {
        this.camera = new SecurityCameraLibrary();
        this.cloudStorage = new CloudStorageProxy();
    }

    @Override
    public void startRecording() {
        System.out.println("CameraProxy: Sending request to CameraLibrary to start recording.");
        camera.startRecording();
    }

    @Override
    public void stopRecording() {
        System.out.println("CameraProxy: Sending request to CameraLibrary to stop recording.");
        camera.stopRecording();
        byte[] videoData = camera.getVideo();
        System.out.println("CameraProxy: Sending request to CloudStorageProxy to forward this video to the cloud service.");
        cloudStorage.uploadVideo(videoData);
    }

    @Override
    public byte[] getVideo() {
        System.out.println("CameraProxy: Sending request to CameraLibrary to return video.");
        return camera.getVideo();
    }
}
// Koniec Tydzień 3, Wzorzec Proxy 1