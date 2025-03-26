package devices.impl.speakers;

import java.util.HashMap;
import java.util.Map;

public class SpeakerFactory {
    private static final Map<String, SpeakerType> speakerTypes = new HashMap<>();

    public static SpeakerType getSpeakerType(String model, String manufacturer, boolean features) {
        String key = model + "_" + manufacturer + "_" + features;
        if (!speakerTypes.containsKey(key)) {
            speakerTypes.put(key, new SpeakerType(model, manufacturer, features));
        }
        return speakerTypes.get(key);
    }
}
