package devices;

import devices.configs.SecurityCameraConfig;
import util.DeviceManager;

public class SecurityCamera implements SmartDevice {
    public static final String CONFIG_KEY = "SecurityCamera";
    private boolean recording;

    public SecurityCamera() {
        SecurityCameraConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, SecurityCameraConfig.class);
        recording = config.isRecording();
    }

    @Override
    public void turnOn() { recording = true; }

    @Override
    public void turnOff() { recording = false; }

    @Override
    public String getStatus() {
        return "Security Camera is " + (recording ? "recording" : "idle");
    }
}

