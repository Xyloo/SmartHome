package devices.proxy;

// Proxy do serwisu obsługującego chmurę danych
public class CloudStorageProxy implements CloudStorage {
    private final CloudStorageService cloudStorageService;

    public CloudStorageProxy() {
        this.cloudStorageService = new CloudStorageService();
    }

    @Override
    public void uploadVideo(byte[] videoData) {
        if (isAvailable()) {
            System.out.println("CloudStorageProxy: Forwarding video from proxy to CloudStorageService.");
            cloudStorageService.uploadVideo(videoData);
        }
    }

    @Override
    public boolean isAvailable() {
        // Checking if CloudStorageService is available like checking access or service status.
        System.out.println("CloudStorageProxy: Checking if CloudStorageService is available.");
        return true;
    }
}