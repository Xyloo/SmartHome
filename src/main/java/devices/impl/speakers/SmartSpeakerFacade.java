package devices.impl.speakers;

import devices.impl.lighting.Light;

// Tydzień 3, Wzorzec Facade 3
public class SmartSpeakerFacade {

    private final SmartSpeakerSystem speakerSystem;

    public SmartSpeakerFacade() {
        this.speakerSystem = new SmartSpeakerSystem();
    }

    public void installSpeaker(String location, String model, String manufacturer, boolean voiceAssistantCapable) {
        speakerSystem.installSpeaker(location, model, manufacturer, voiceAssistantCapable);
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

    public void playMusicOnSpeaker(String location, String song) {
        for (SmartSpeaker speaker : speakerSystem.getAllSpeakers()) {
            if (speaker.getLocation().equals(location)) {
                speaker.playMusic(song);
                break;
            }
        }
    }

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
        setVolumeForAll(90);

        Light light = getLighting();
        light.setBrightness(90);
    }
    // Simulation of getting lighting system
    private Light getLighting(){
        return new Light();
    }
}
// Koniec Tydzień 3, Wzorzec Facade 3
