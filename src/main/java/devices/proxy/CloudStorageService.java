package devices.proxy;

public class CloudStorageService implements CloudStorage {
    @Override
    public void uploadVideo(byte[] videoData) {
        System.out.println("CloudService: Uploading video to the cloud");
    }

    @Override
    public boolean isAvailable() {
        System.out.println("CloudService: Checking if service is available for requester");
        return true;
    }
}