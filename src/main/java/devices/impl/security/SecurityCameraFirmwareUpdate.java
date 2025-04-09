package devices.impl.security;

import devices.template.FirmwareUpdateTemplate;

public class SecurityCameraFirmwareUpdate extends FirmwareUpdateTemplate
{
    private SecurityCamera camera;

    public SecurityCameraFirmwareUpdate(SecurityCamera camera) {
        this.camera = camera;
    }

    @Override
    protected void prepareForUpdate() {
        System.out.println("Preparing " + camera + " for firmware update (disabling live streaming).");
        camera.stopRecording();
    }

    @Override
    protected String checkFirmwareVersion() {
        String version = "3.2";
        System.out.println("Current firmware version of camera: " + version);
        return version;
    }

    @Override
    protected String downloadFirmware(String currentVersion) {
        String newFirmware = "3.3";
        System.out.println("Downloading firmware " + newFirmware + " for camera.");
        return newFirmware;
    }

    @Override
    protected void installFirmware(String firmware) {
        System.out.println("Installing firmware " + firmware + " on security camera.");
    }

    @Override
    protected boolean verifyInstallation() {
        System.out.println("Checking firmware status on security camera.");
        return true;
    }

    @Override
    protected void rollbackUpdate() {
        System.out.println("Firmware update failed for camera. Rolling back changes.");
    }
}

