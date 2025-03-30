package devices.impl.speakers;

public interface SmartSpeakerIterator {
    boolean hasNext();
    SmartSpeaker next();
    void onLocation(String location);
}
