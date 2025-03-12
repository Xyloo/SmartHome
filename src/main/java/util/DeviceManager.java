package util;

import devices.Light;
import devices.SecurityCamera;
import devices.SmartPlug;
import devices.configs.*;

import java.util.HashMap;
import java.util.Map;

// Tydzień 1, Wzorzec Singleton 2
// Wzorzec Singleton pozwala na stworzenie tylko jednej instancji danej klasy w obrębie całego programu.
// Poniższa implementacja wykorzystuje wyliczenie (enum) do stworzenia Singletona, co gwarantuje bezpieczeństwo wątkowe.
// Klasa DeviceManager zarządza konfiguracjami urządzeń, przechowywanymi w mapie.
// Domyślne ustawienia są ładowane metodą loadDefaultSettings(), a metoda getSetting() umożliwia pobranie
// ustawienia dla danego urządzenia w sposób typowany.
// Dodatkowo, do tworzenia obiektów konfiguracji zastosowano wzorzec Builder, co zapewnia czytelny i elastyczny
// sposób inicjalizacji obiektów konfiguracji.

public enum DeviceManager {
    INSTANCE;

    private Map<String, DeviceConfig> config;

    DeviceManager() {
        util.SmartLogger.getInstance().log("Creating Singletone - DeviceManager");
        config = new HashMap<>();
        loadDefaultSettings();
    }

    private void loadDefaultSettings() {
        config.put(Light.CONFIG_KEY, ConfigFactory.createConfig("light"));
        config.put(SecurityCamera.CONFIG_KEY, ConfigFactory.createConfig("securityCamera"));
        config.put(SmartPlug.CONFIG_KEY, ConfigFactory.createConfig("smartPlug"));
    }

    @SuppressWarnings("unchecked")
    public <T extends DeviceConfig> T getSetting(String key, Class<T> clazz) {
        DeviceConfig setting = config.get(key);
        if (clazz.isInstance(setting)) {
            return (T) setting;
        } else {
            throw new IllegalArgumentException("Setting for key " + key + " is not of type " + clazz.getName());
        }
    }
}
