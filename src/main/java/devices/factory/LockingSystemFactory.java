package devices.factory;

import devices.impl.security.lockingsystem.*;

import java.util.HashMap;
import java.util.Map;

public class LockingSystemFactory {
    private static final Map<String, BlindType> blinds = new HashMap<>();

    public static BlindType getBlinds(String type, String color, String anyOtherParameter) {
        String key = type + "_" + color + "_" + anyOtherParameter;

        BlindType blind = blinds.get(key);

        if (blind == null) {
            blind = new BlindType(type,color,anyOtherParameter);
            blinds.put(key, blind);
            System.out.println("New blind added: " + key);
        }

        return blind;
    }

}