package devices.configs;

public class SecurityCameraConfig implements DeviceConfig, Cloneable {
    private final boolean isRecording;

    private SecurityCameraConfig(Builder builder) {
        this.isRecording = builder.isRecording;
        util.SmartLogger.getInstance().log(this.toString());
    }

    public boolean isRecording() {
        return isRecording;
    }

    @Override
    public String toString() {
        return "SecurityCameraConfig [isRecording=" + isRecording + "]";
    }

    @Override
    public SecurityCameraConfig clone() {
        try {
            return (SecurityCameraConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    public static class Builder {
        private boolean isRecording = false;

        public Builder isRecording(boolean isRecording) {
            this.isRecording = isRecording;
            return this;
        }

        public SecurityCameraConfig build() {
            return new SecurityCameraConfig(this);
        }
    }
}
