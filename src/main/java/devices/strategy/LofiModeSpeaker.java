package devices.strategy;

import devices.impl.speakers.SmartSpeaker;

public class LofiModeSpeaker implements SpeakersModeStrategy{
    @Override
    public void play(SmartSpeaker speaker) {
        System.out.println("Speaker setting up lofi mode...");
        speaker.setVolume(65);
        speaker.playMusic("Lofi playlist");
    }
}
