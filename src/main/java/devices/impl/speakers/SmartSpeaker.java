package devices.impl.speakers;

import devices.impl.SmartDevice;
import util.SmartLogger;

public class SmartSpeaker implements SmartDevice
{
    private final SpeakerType speakerType; // intrinsic state
    private final String location;         // extrinsic state
    private int volume;
    private boolean isOn = false;
    private final SmartLogger logger = SmartLogger.getInstance();

    public SmartSpeaker(SpeakerType speakerType, String location) {
        this.speakerType = speakerType;
        this.location = location;
        this.volume = 50; // default volume level
    }

    public void playMusic(String song) {
        isOn = true;
        logger.log(this,"Playing \"" + song + "\" on "
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
        isOn = true;
        logger.log(this, "Turning on " + speakerType.getModel() + " at " + location);
    }

    @Override
    public void turnOff()
    {
        isOn = false;
        logger.log(this, "Turning off " + speakerType.getModel() + " at " + location);
    }

    @Override
    public String getStatus()
    {
        return "Speaker is " + (isOn ? "ON" : "OFF") + " at " + location;
    }
}
