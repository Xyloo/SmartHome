package devices.configs;

public class LightConfig implements DeviceConfig, Cloneable {
    private final boolean initialState;
    private final int brightness;

    private LightConfig(Builder builder) {
        this.initialState = builder.initialState;
        this.brightness = builder.brightness;
        util.SmartLogger.getInstance().log(this.toString());
    }

    public boolean getInitialState() {
        return initialState;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String toString() {
        return "LightConfig [initialState=" + initialState + ", brightness=" + brightness + "]";
    }

    @Override
    public LightConfig clone() {
        try {
            return (LightConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    public static class Builder {
        private boolean initialState;
        private int brightness;

        public Builder initialState(boolean initialState) {
            this.initialState = initialState;
            return this;
        }

        public Builder brightness(int brightness) {
            this.brightness = brightness;
            return this;
        }

        public LightConfig build() {
            return new LightConfig(this);
        }
    }
}
