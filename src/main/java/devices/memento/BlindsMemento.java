package devices.memento;

// Tydzien 6 Wzorzec Memento 1
public class BlindsMemento {
    private final int coveringLevel;
    private final String mode;
    private final boolean isOpen;

    public BlindsMemento(int coveringLevel, String mode, boolean isOpen) {
        this.coveringLevel = coveringLevel;
        this.mode = mode;
        this.isOpen = isOpen;
    }

    public int getCoveringLevel() {
        return coveringLevel;
    }

    public String getMode() {
        return mode;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
// Koniec Tydzień 6 Wzorzec Memento 1