package devices.configs;

public class BlindConfig {
    private final String type;
    private final String color;
    private final String extra;

    public BlindConfig(String type, String color, String extra) {
        this.type  = type;
        this.color = color;
        this.extra = extra;
    }

    public String getType()  { return type;  }
    public String getColor() { return color; }
    public String getExtra() { return extra; }
}