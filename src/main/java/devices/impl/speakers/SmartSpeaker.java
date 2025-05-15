package devices.impl.speakers;

import devices.impl.SmartDevice;
import devices.impl.SpeakerVolumeConstants;
import devices.mediator.Mediator;
import devices.strategy.SpeakersModeStrategy;
import util.SmartLogger;

public class SmartSpeaker implements SmartDevice
{
    private final SpeakerType speakerType; // intrinsic state
    private final String location;         // extrinsic state
    private int volume;
    private boolean isPlaying = false;
    private final SmartLogger logger = SmartLogger.getInstance();
    private Mediator mediator;
    private SpeakersModeStrategy strategy;

    public SmartSpeaker(SpeakerType speakerType, String location) {
        this.speakerType = speakerType;
        this.location = location;
        this.volume = SpeakerVolumeConstants.DEFAULT_VOLUME; // default volume level
    }

    //Tydzień 5, Wzorzec Strategy 2
    public void setStrategy(SpeakersModeStrategy strategy) {
        this.strategy = strategy;
    }

    public void playPlaylist(){
        if (strategy != null) {
            strategy.play(this);
        } else {
            SmartLogger.getInstance().log(this, "Speakers modes strategy not set.");
        }
    }
    //Koniec Tydzień 5, Wzorzec Strategy 2

    public void playMusic(String song) {
        isPlaying = true;
        logger.log(this,"Playing \"" + song + "\" on "
                + speakerType.getModel() + " at " + location);
    }

    public void stopMusic() {
        isPlaying = false;
        logger.log(this,"Stopping music on "
                + speakerType.getModel() + " at " + location);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        logger.log(this, "Setting volume to " + volume + " at " + location);
    }
    public String getLocation(){
        return this.location;
    }
    @Override
    public void turnOn()
    {
        isPlaying = true;
        logger.log(this, "Turning on " + speakerType.getModel() + " at " + location);
    }

    @Override
    public void turnOff()
    {
        isPlaying = false;
        logger.log(this, "Turning off " + speakerType.getModel() + " at " + location);
    }

    @Override
    public String getStatus()
    {
        return "Speaker is " + (isPlaying ? "ON" : "OFF") + " at " + location;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        if(event.equals("SPEAKER_VOLUME_50")){
            setVolume(SpeakerVolumeConstants.DEFAULT_VOLUME);
        }
    }
}
