package devices.impl.security.lockingsystem;

public class Blind implements SmartBlind{
    private final String location;
    private double coveringLevel;
    private boolean isOpen;
    private final BlindType blindType;

    public Blind(BlindType type, String location) {
        this.blindType = type;
        this.location = location;
        this.isOpen = true;
        this.coveringLevel = 0;
    }
    @Override
    public void info() {
        System.out.println(blindType.type + " żaluzje w lokalizacji: " + location + " - stan: " + (isOpen ? "odsłonięte" : "zasłonięte"));
    }

    @Override
    public void open() {
        this.isOpen = true;
        this.coveringLevel = 0;
        System.out.println("Odsłaniam " + blindType.type + " żaluzje w lokalizacji: " + location + " Poziom zasłonięcia: " + coveringLevel);
    }

    @Override
    public void close() {
        this.isOpen = false;
        this.coveringLevel = 100;
        System.out.println("Zasłaniam " + blindType.type + " żaluzje w lokalizacji: " + location + " Poziom zasłonięcia: " + coveringLevel);
    }
}