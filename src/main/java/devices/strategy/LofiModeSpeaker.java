package devices.strategy;

import devices.impl.SpeakerVolumeConstants;
import devices.impl.speakers.SmartSpeaker;

public class LofiModeSpeaker implements SpeakersModeStrategy{
    @Override
    public void play(SmartSpeaker speaker) {
        System.out.println("Speaker setting up lofi mode...");
        speaker.setVolume(SpeakerVolumeConstants.DEFAULT_VOLUME);
        speaker.playMusic("Lofi playlist");
    }
}
