package devices.impl.speakers;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Flyweight 3
public class SmartSpeakerSystem {
    private final List<SmartSpeaker> speakers = new ArrayList<>();

    public void installSpeaker(String location, String model, String manufacturer, boolean voiceAssistantCapable) {
        SpeakerType type = SpeakerFactory.getSpeakerType(model, manufacturer, voiceAssistantCapable);
        SmartSpeaker speaker = new SmartSpeaker(type, location);
        speakers.add(speaker);
        System.out.println("Installed " + model + " speaker at " + location);
    }

    public void playMusicOnAll(String song) {
        for (SmartSpeaker speaker : speakers) {
            speaker.playMusic(song);
        }
    }

    public void setAllVolumes(int volume) {
        for (SmartSpeaker speaker : speakers) {
            speaker.setVolume(volume);
        }
    }
    public List<SmartSpeaker> getAllSpeakers(){
        return speakers;
    }

}
// Koniec Tydzień 3, Wzorzec Flyweight 3
