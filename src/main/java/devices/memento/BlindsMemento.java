package devices.memento;

// Tydzien 6 Wzorzec Memento 1
public class BlindsMemento {
    private final int coveringLevel;
    private final String mode;

    public BlindsMemento(int coveringLevel, String mode) {
        this.coveringLevel = coveringLevel;
        this.mode = mode;
    }

    public int getCoveringLevel() {
        return coveringLevel;
    }

    public String getMode() {
        return mode;
    }
}
// Koniec Tydzień 6 Wzorzec Memento 1