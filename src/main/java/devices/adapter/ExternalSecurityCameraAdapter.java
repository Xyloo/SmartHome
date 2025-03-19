package devices.adapter;

import devices.impl.AbstractSmartDevice;
import devices.impl.security.ExternalSecurityCamera;
import devices.impl.security.SecurityCameraDevice;

public class ExternalSecurityCameraAdapter extends AbstractSmartDevice implements SecurityCameraDevice {
    protected ExternalSecurityCamera device;

    public ExternalSecurityCameraAdapter(ExternalSecurityCamera device) {
        this.device = device;
    }

    @Override
    public String getStatus() {
        util.SmartLogger.getInstance().log("[ExternalSecurityCameraAdapter] getStatus");
        return device.showDeviceState();
    }

    @Override
    public void startRecording() {
        util.SmartLogger.getInstance().log("[ExternalSecurityCameraAdapter] startRecording");
        if(!device.isRecording())
            device.toggleRecording();
    }

    @Override
    public void stopRecording() {
        util.SmartLogger.getInstance().log("[ExternalSecurityCameraAdapter] stopRecording");
        if(device.isRecording())
            device.toggleRecording();
    }

    @Override
    public void takeSnapshot() {
        util.SmartLogger.getInstance().log("[ExternalSecurityCameraAdapter] takeSnapshot");
        device.saveDataToExternalStorage();
    }

    @Override
    public void setMotionDetectionEnabled(boolean enabled) {
        if(device.isMotionDetectionEnabled() != enabled)
            device.toggleMotionDetection();
    }

    @Override
    public boolean isMotionDetectionEnabled() {
        return device.isMotionDetectionEnabled();
    }

    @Override
    public void setAutoRecordingEnabled(boolean enabled) {
        if(device.isRecording() != enabled)
            device.toggleRecording();
    }

    @Override
    public boolean isAutoRecordingEnabled() {
        return device.isAutoRecording();
    }
}
