package devices.impl.speakers;

import devices.configs.SpeakerConfig;
import devices.impl.LightBrightnessConstants;
import devices.impl.SpeakerVolumeConstants;
import devices.impl.lighting.Light;

// Tydzień 3, Wzorzec Facade 3
public class SmartSpeakerFacade {

    private final SmartSpeakerSystem speakerSystem;

    public SmartSpeakerFacade() {
        this.speakerSystem = new SmartSpeakerSystem();
    }

    public void installSpeaker(String location, SpeakerConfig config) {
        speakerSystem.installSpeaker(location, config);
    }

    public void playMusicOnAll(String song) {
        speakerSystem.playMusicOnAll(song);
    }

    public void setVolumeForAll(int volume) {
        speakerSystem.setAllVolumes(volume);
    }

    public void turnOnAllSpeakers() {
        for (SmartSpeaker speaker : speakerSystem.getAllSpeakers()) {
            speaker.turnOn();
        }
    }

    public void turnOffAllSpeakers() {
        for (SmartSpeaker speaker : speakerSystem.getAllSpeakers()) {
            speaker.turnOff();
        }
    }

    // Tydzień 4, Wzorzec Iterator 2
    public void playMusicOnSpeaker(String location, String song) {
        SmartSpeakerIterator iterator = speakerSystem.getLocationFilteredIterator(location);
        if(!iterator.hasNext())
            System.out.println("No speakers found in the " + location);
        while (iterator.hasNext()) {
            SmartSpeaker speaker = iterator.next();
            speaker.playMusic(song);
        }
    }
    // Koniec Tydzien 4, Wzorzec Iterator 2
    public void setVolumeForSpeaker(String location, int volume) {
        for (SmartSpeaker speaker : speakerSystem.getAllSpeakers()) {
            if (speaker.getLocation().equals(location)) {
                speaker.setVolume(volume);
                break;
            }
        }
    }
    public void activatePartyMode() {
        System.out.println("Activating Party Mode");
        playMusicOnAll("Party Playlist");
        setVolumeForAll(SpeakerVolumeConstants.SPEAKER_PARTY);

        Light light = getLighting();
        light.setBrightness(LightBrightnessConstants.LIGHT_BRIGHT);
    }
    // Simulation of getting lighting system
    private Light getLighting(){
        return new Light();
    }
}
// Koniec Tydzień 3, Wzorzec Facade 3
