package devices.configs;

public class ConfigFactory {

    public static DeviceConfig createConfig(String deviceType) {
        if (deviceType.equalsIgnoreCase("light")) {
            return new LightConfig.Builder()
                    .initialState(false)
                    .brightness(60)
                    .build();
        } else if (deviceType.equalsIgnoreCase("securityCamera")) {
            return new SecurityCameraConfig.Builder()
                    .isRecording(true)
                    .build();
        } else if (deviceType.equalsIgnoreCase("smartPlug")) {
            return new SmartPlugConfig.Builder()
                    .isOn(false)
                    .deviceName("defaultSmartPlug")
                    .build();
        }
        throw new IllegalArgumentException("Unknown device type: " + deviceType);
    }
}
