package devices.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CameraProxyTest {
    private CameraProxy proxy;
    private StubCameraLibrary stubCamera;
    private StubCloudStorage stubStorage;

    @BeforeEach
    void setUp() throws Exception {
        proxy = new CameraProxy();

        stubCamera = new StubCameraLibrary();
        Field cameraField = CameraProxy.class.getDeclaredField("camera");
        cameraField.setAccessible(true);
        cameraField.set(proxy, stubCamera);

        stubStorage = new StubCloudStorage();
        Field storageField = CameraProxy.class.getDeclaredField("cloudStorage");
        storageField.setAccessible(true);
        storageField.set(proxy, stubStorage);
    }

    @Test
    void initializeCamera_ShouldConfigureLibrary() {
        proxy.initializeCamera("1080p", "50ms", "SAVE_ONCE");
        assertEquals("1080p", stubCamera.resolution, "Resolution set");
        assertEquals("50ms", stubCamera.delay, "Delay set");
        assertEquals("SAVE_ONCE", stubCamera.savingSettings, "Saving settings set");
    }

    @Test
    void startRecording_ShouldInvokeStartOnLibrary() {
        proxy.startRecording();
        assertTrue(stubCamera.started, "startRecording delegated");
    }

    @Test
    void stopRecording_ShouldStopAndUploadVideo() {
        stubCamera.videoData = new byte[]{1,2,3};

        proxy.stopRecording();

        assertTrue(stubCamera.stopped, "stopRecording delegated");
        assertArrayEquals(new byte[]{1,2,3}, stubStorage.uploadedData, "Uploaded video data");
    }

    @Test
    void getVideo_ShouldReturnLibraryVideo() {
        stubCamera.videoData = new byte[]{9,8,7};
        byte[] result = proxy.getVideo();
        assertArrayEquals(new byte[]{9,8,7}, result, "getVideo returns data");
    }

    // Stub implementations
    private static class StubCameraLibrary extends SecurityCameraLibrary {
        String resolution;
        String delay;
        String savingSettings;
        boolean started;
        boolean stopped;
        byte[] videoData;

        @Override
        public void setResolution(String res) { this.resolution = res; }
        @Override
        public void setDelay(String d) { this.delay = d; }
        @Override
        public void setSavingSettings(String s) { this.savingSettings = s; }
        @Override
        public void startRecording() { this.started = true; }
        @Override
        public void stopRecording() { this.stopped = true; }
        @Override
        public byte[] getVideo() { return videoData; }
    }

    private static class StubCloudStorage implements CloudStorage {
        byte[] uploadedData;
        @Override
        public void uploadVideo(byte[] data) { this.uploadedData = data; }

        @Override
        public boolean isAvailable() {
            return false;
        }
    }
}
