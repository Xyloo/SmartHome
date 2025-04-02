package devices.factory;

import devices.impl.SmartDevice;
import devices.impl.SmartPlug;
import devices.impl.Thermostat;
import devices.impl.lighting.Light;
import devices.impl.security.SecurityCamera;
import devices.impl.window.SecureWindow;

// Tydzień 1, Wzorzec Factory 1
// Wzorzec fabryki pozwala na tworzenie obiektów bez konieczności ujawniania logiki tworzenia obiektów.
// Umożliwia to zastosowanie polimorfizmu, co pozwala na traktowanie obiektów w sposób ogólny, bez konieczności wiedzenia, jakie są ich rzeczywiste typy.
public class DeviceFactory {
    public static SmartDevice createDevice( String type) {
        if (type.equalsIgnoreCase("light")) {
            return new Light ();
        } else if (type.equalsIgnoreCase("thermostat")) {
            return new Thermostat ();
        } else if (type.equalsIgnoreCase("camera")) {
            return new SecurityCamera ();
        } else if (type.equalsIgnoreCase("smartPlug")) {
            return new SmartPlug ();
        }

        throw new IllegalArgumentException("Unknown device type");
    }
}
// Koniec, Tydzień 1, Wzorzec Factory 1
