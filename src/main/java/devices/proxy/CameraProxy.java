package devices.proxy;

public class CameraProxy implements Camera {
    private final SecurityCameraLibrary camera;
    private final CloudStorage cloudStorage;

    public CameraProxy() {
        this.camera = new SecurityCameraLibrary();
        this.cloudStorage = new CloudStorageProxy();
    }

    public void initializeCamera(String resolution, String delay, String savingSettings){
        System.out.println("CameraProxy: Initialize camera.");
        camera.setResolution(resolution);
        camera.setDelay(delay);
        camera.setSavingSettings(savingSettings);
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