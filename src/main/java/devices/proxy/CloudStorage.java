package devices.proxy;

// Wspólny interfejs dla CloudStorageService oraz CloudStorageProxy
public interface CloudStorage {
    void uploadVideo(byte[] videoData);
    boolean isAvailable();
}