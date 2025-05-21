package devices.configs;

import devices.impl.LightBrightnessConstants;
import devices.impl.SmartPlug;
import devices.impl.lighting.Light;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class DeviceManagerTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        Field f = DeviceManager.class.getDeclaredField("instance");
        f.setAccessible(true);
        f.set(null, null);
    }

    @Test
    void getInstance_beforeInit_throwsException(){
        assertThrows(IllegalStateException.class,
                () -> DeviceManager.getInstance(),
                "Should throw exception if init() has not been called");
    }

    @Test
    void init_andGetInstance_returnsSameInstance() {
        InMemoryConfigRepository repo = new InMemoryConfigRepository();
        DeviceManager.init(repo);
        DeviceManager mgr1 = DeviceManager.getInstance();
        DeviceManager mgr2 = DeviceManager.getInstance();
        assertSame(mgr1, mgr2, "getInstance() should always return the same object");
    }

    @Test
    void loadDefaultSettings_populatesLightConfig() {
        InMemoryConfigRepository repo = new InMemoryConfigRepository();
        DeviceManager.init(repo);

        LightConfig cfg = DeviceManager.getInstance()
                .getSetting(Light.CONFIG_KEY, LightConfig.class);
        assertNotNull(cfg, "LightConfig should be loaded by default");

        assertFalse(cfg.getInitialState());
        assertEquals(LightBrightnessConstants.DEFAULT_BRIGHTNESS, cfg.getBrightness());
    }

    @Test
    void getSetting_withWrongConfigKey_causesIllegalArgumentException() {
        InMemoryConfigRepository repo = new InMemoryConfigRepository();
        DeviceManager.init(repo);
        assertThrows(IllegalArgumentException.class, () -> {
            DeviceManager.getInstance()
                    .getSetting(SmartPlug.CONFIG_KEY, LightConfig.class);
        });
    }

    @Test
    void init_multipleTimes_usesFirstRepositoryOnly() {
        InMemoryConfigRepository first = new InMemoryConfigRepository();
        DeviceManager.init(first);

        first.save("foo", new LightConfig.Builder().initialState(true).brightness(10).build());

        InMemoryConfigRepository second = new InMemoryConfigRepository();
        second.save("foo", new LightConfig.Builder().initialState(false).brightness(20).build());
        DeviceManager.init(second);

        LightConfig cfg = DeviceManager.getInstance()
                .getSetting("foo", LightConfig.class);
        assertEquals(10, cfg.getBrightness());
    }
}