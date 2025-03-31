package devices.impl.speakers;

import java.util.List;

public class SmartSpeakerLocationIterator implements SmartSpeakerIterator {
    private List<SmartSpeaker> speakers;
    private int currentIndex = 0;
    private String locationFilter;

    public SmartSpeakerLocationIterator(List<SmartSpeaker> speakers) {
        this.speakers = speakers;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < speakers.size()) {
            SmartSpeaker speaker = speakers.get(currentIndex);
            if (locationFilter == null || speaker.getLocation().equals(locationFilter)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public SmartSpeaker next() {
        if (this.hasNext()) {
            return speakers.get(currentIndex++);
        }
        return null;
    }

    @Override
    public void onLocation(String location) {
        this.locationFilter = location;
    }
}