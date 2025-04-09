package devices.strategy;

import devices.impl.speakers.SmartSpeaker;

public class PartyModeSpeaker implements SpeakersModeStrategy {

    @Override
    public void play(SmartSpeaker speaker) {
        System.out.println("Speaker setting up party mode...");
        speaker.setVolume(85);
        speaker.playMusic("Party playlist");
    }
}
