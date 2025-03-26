package home;

import devices.impl.SmartDevice;

import java.util.ArrayList;
import java.util.List;

// Tydzień 1, Wzorzec Builder 1
// Wzorzec budowniczego pozwala na tworzenie obiektów, które mają wiele opcji konfiguracyjnych.
// Umożliwia to tworzenie obiektów z wieloma opcjami konfiguracyjnymi w sposób czytelny i intuicyjny.
public class SmartHome {
    private String name;
    private String location;
    private List<SmartDevice> devices;

    private SmartHome(Builder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.devices = builder.devices;
    }

    public static class Builder {
        private String name;
        private String location;
        private List<SmartDevice> devices = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder addDevice(SmartDevice device) {
            devices.add(device);
            return this;
        }

        public SmartHome build() {
            return new SmartHome(this);
        }
    }

    public <T extends SmartDevice> List<T> getDevicesOfType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (SmartDevice device : devices) {
            if (type.isInstance(device)) {
                result.add(type.cast(device));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "SmartHome{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", devices=" + devices.size() +
                '}';
    }
}
// Koniec, Tydzień 1, Wzorzec Builder 1
