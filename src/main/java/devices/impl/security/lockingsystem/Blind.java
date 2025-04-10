package devices.impl.security.lockingsystem;

import devices.memento.BlindsMemento;

public class Blind implements SmartBlind{
    private final String location;
    private int coveringLevel;
    private boolean isOpen;
    private String mode;
    private final BlindType blindType;

    public Blind(BlindType type, String location) {
        this.blindType = type;
        this.location = location;
        this.mode = "Auto";
        this.isOpen = true;
        this.coveringLevel = 0;
    }
    @Override
    public void info() {
        System.out.println(blindType.type + " żaluzje w lokalizacji: " + location + " - stan: " + (isOpen ? "odsłonięte (poziom zasłonięcia: "+coveringLevel+"%) "  : "zasłonięte") + " tryb: "+mode);
    }

    @Override
    public void open() {
        this.isOpen = true;
        this.coveringLevel = 0;
        System.out.println("Odsłaniam " + blindType.type + " żaluzje w lokalizacji: " + location + " Poziom zasłonięcia: " + coveringLevel);
    }

    @Override
    public void setState(int coveringLevel, String mode) {
        this.coveringLevel = coveringLevel;
        this.mode = mode;
    }
    // Tydzien 6 Wzorzec Memento 1
    public BlindsMemento saveState() {
        return new BlindsMemento(coveringLevel, mode);
    }
    public void restoreState(BlindsMemento memento) {
        this.coveringLevel = memento.getCoveringLevel();
        this.mode = memento.getMode();
    }
    // Koniec Tydzień 6 Wzorzec Memento 1
    @Override
    public void close() {
        this.isOpen = false;
        this.coveringLevel = 100;
        System.out.println("Zasłaniam " + blindType.type + " żaluzje w lokalizacji: " + location + " Poziom zasłonięcia: " + coveringLevel);
    }
}