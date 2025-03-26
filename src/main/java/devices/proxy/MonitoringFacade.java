package devices.proxy;

public class MonitoringFacade {
    private final CameraProxy camera;
    private final CloudStorageProxy cloudStorage;

    public MonitoringFacade(){
        camera = new CameraProxy();
        cloudStorage = new CloudStorageProxy();

        initializeCamera();
        initializeCloud();
    }

    private void initializeCloud() {
        String resolution = getResolutionParameter();
        String delay = getDelayParameter();
        String saveSettings = getSavingSettings();

        camera.initializeCamera(resolution,delay,saveSettings);
    }

    private void initializeCamera() {
        String user = getCloudUser();
        String password = getCloudPassword();

        cloudStorage.loginToCloud(user,password);
    }
    public void startRecording(){
        camera.startRecording();
    }
    public void stopRecording(){
        camera.stopRecording();
    }

    // Simulation of getting parameters needed to initialize services
    private String getResolutionParameter(){
        return "720p";
    }
    private String getDelayParameter(){
        return "30ms";
    }
    private String getSavingSettings(){
        return "SAVE_ALWAYS";
    }
    private String getCloudUser(){
        return "user";
    }
    private String getCloudPassword(){
        return "******";
    }
}
