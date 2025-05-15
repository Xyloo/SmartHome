package devices.interpreter;

import devices.impl.speakers.SmartSpeaker;

import java.util.HashMap;
import java.util.Map;

public class SpeakersContext {
    private final Map<String, SmartSpeaker> speakersMap = new HashMap<>();

    public void addDevice(String name, SmartSpeaker device) {
        speakersMap.put(name.toLowerCase(), device);
    }

    public SmartSpeaker getDevice(String name) {
        return speakersMap.get(name.toLowerCase());
    }
}
