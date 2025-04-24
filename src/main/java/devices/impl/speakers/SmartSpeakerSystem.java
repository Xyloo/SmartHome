package devices.impl.speakers;

import devices.strategy.PartyModeSpeaker;
import devices.strategy.SpeakersModeStrategy;
import util.SmartLogger;

import java.util.ArrayList;
import java.util.List;

// Tydzień 3, Wzorzec Flyweight 3
public class SmartSpeakerSystem {
    private final List<SmartSpeaker> speakers = new ArrayList<>();
    private final List<SpeakersModeStrategy> strategies = new ArrayList<>();
    private final SmartLogger logger = SmartLogger.getInstance();

    public SmartSpeaker installSpeaker(String location, String model, String manufacturer, boolean voiceAssistantCapable) {
        SpeakerType type = SpeakerFactory.getSpeakerType(model, manufacturer, voiceAssistantCapable);
        SmartSpeaker speaker = new SmartSpeaker(type, location);
        speakers.add(speaker);
        System.out.println("Installed " + model + " speaker at " + location);
        return speaker;
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

    public SmartSpeakerIterator getLocationFilteredIterator(String location) {
        SmartSpeakerLocationIterator iterator = new SmartSpeakerLocationIterator(speakers);
        iterator.onLocation(location);
        return iterator;
    }

    public void addStrategy(SpeakersModeStrategy strategy) {
        strategies.add(strategy);
    }

    public void removeStrategy(SpeakersModeStrategy strategy) {
        strategies.remove(strategy);
    }

    public void setStrategies(List<SpeakersModeStrategy> strategies)
    {
        this.strategies.clear();
        this.strategies.addAll(strategies);
    }

    public void activatePartyMode() {
        for (var speaker : speakers)
        {
            speaker.setStrategy(new PartyModeSpeaker());
            logger.log(this, "Applied strategy PartyModeSpeaker on " + speaker.getLocation());
        }
    }

    public void setStrategyToAllSpeakers(SpeakersModeStrategy strategy)
    {
        for (var speaker : speakers)
        {
            speaker.setStrategy(strategy);
            logger.log(this, "Applied strategy " + strategy.getClass().getSimpleName() + " on " + speaker.getLocation());
        }
    }

    public void applyStrategies()
    {
        var speakerCount = speakers.size();
        var strategiesCount = strategies.size();

        for (int i = 0; i < speakerCount; i++)
        {
            var speaker = speakers.get(i);
            var strategy = strategies.get(i % strategiesCount);
            speaker.setStrategy(strategy);
            logger.log(this, "Applied strategy " + strategy.getClass().getSimpleName() + " on " + speaker.getLocation());
        }
    }
}
// Koniec Tydzień 3, Wzorzec Flyweight 3
