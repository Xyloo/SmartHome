package devices.configs;

import java.util.HashMap;
import java.util.Map;

public class InMemoryConfigRepository implements DeviceConfigRepository {
    private final Map<String, DeviceConfig> store = new HashMap<>();

    @Override
    public DeviceConfig load(String key) {
        return store.get(key);
    }

    @Override
    public void save(String key, DeviceConfig config) {
        store.put(key, config);
    }
}