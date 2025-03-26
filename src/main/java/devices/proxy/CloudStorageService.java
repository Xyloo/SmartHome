package devices.proxy;

public class CloudStorageService implements CloudStorage {
    private String user;
    private String password;

    @Override
    public void uploadVideo(byte[] videoData) {
        System.out.println("CloudService: Uploading video to the cloud");
    }

    @Override
    public boolean isAvailable() {
        System.out.println("CloudService: Checking if service is available for requester");
        return true;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}