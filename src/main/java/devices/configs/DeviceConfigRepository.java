package devices.configs;

public interface DeviceConfigRepository {
    DeviceConfig load(String key);
    void save(String key, DeviceConfig config);
}
