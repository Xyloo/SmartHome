package devices.configs;

import devices.impl.lighting.Light;
import devices.impl.security.SecurityCamera;

public class DeviceManager {
    private static DeviceManager instance;
    private final ConfigProvider configProvider;

    private DeviceManager(DeviceConfigRepository repo) {
        this.configProvider = new ConfigProvider(repo);
        loadDefaultSettings();
    }

    public static synchronized void init(DeviceConfigRepository repo) {
        if (instance == null) {
            instance = new DeviceManager(repo);
        }
    }

    public static DeviceManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Must call init() first");
        }
        return instance;
    }


    private void loadDefaultSettings() {
        configProvider.getOrCreate(Light.CONFIG_KEY, LightConfig.class);
        configProvider.getOrCreate(SecurityCamera.CONFIG_KEY, SecurityCameraConfig.class);
    }


    public <T extends DeviceConfig> T getSetting(String key, Class<T> clazz) {
        return configProvider.getOrCreate(key, clazz);
    }
}
