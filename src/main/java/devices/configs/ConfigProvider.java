package devices.configs;

import devices.impl.LightBrightnessConstants;

public class ConfigProvider {
    private final DeviceConfigRepository repo;

    public ConfigProvider(DeviceConfigRepository repo) {
        this.repo = repo;
    }

    public <T extends DeviceConfig> T getOrCreate(String key, Class<T> clazz) {
        DeviceConfig cfg = repo.load(key);
        if (cfg != null && clazz.isInstance(cfg)) {
            return (T) cfg;
        }
        DeviceConfig defaultCfg = createDefault(key);
        repo.save(key, defaultCfg);
        return (T) defaultCfg;
    }

    private DeviceConfig createDefault(String deviceType) {
        switch (deviceType.toLowerCase()) {
            case "light":
                return new LightConfig.Builder()
                        .initialState(false)
                        .brightness(LightBrightnessConstants.DEFAULT_BRIGHTNESS)
                        .build();
            case "securitycamera":
                return new SecurityCameraConfig.Builder()
                        .isRecording(true)
                        .build();
            case "smartplug":
                return new SmartPlugConfig.Builder()
                        .isOn(false)
                        .deviceName("defaultSmartPlug")
                        .build();
            default:
                throw new IllegalArgumentException("Unknown device type: " + deviceType);
        }
    }
}
