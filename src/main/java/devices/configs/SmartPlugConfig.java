package devices.configs;

public class SmartPlugConfig implements DeviceConfig, Cloneable {
    private final boolean isOn;
    private final String deviceName;

    private SmartPlugConfig(Builder builder) {
        this.isOn = builder.isOn;
        this.deviceName = builder.deviceName;
        util.SmartLogger.getInstance().log(this.toString());
    }

    public boolean isOn() {
        return isOn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public String toString() {
        return "SmartPlugConfig [isOn=" + isOn + ", deviceName=" + deviceName + "]";
    }

    @Override
    public SmartPlugConfig clone() {
        try {
            return (SmartPlugConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    public static class Builder {
        private boolean isOn;
        private String deviceName;

        public Builder isOn(boolean isOn) {
            this.isOn = isOn;
            return this;
        }

        public Builder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        public SmartPlugConfig build() {
            return new SmartPlugConfig(this);
        }
    }
}
