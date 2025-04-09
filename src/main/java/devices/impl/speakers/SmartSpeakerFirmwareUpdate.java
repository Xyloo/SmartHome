package devices.impl.speakers;

import devices.impl.speakers.SmartSpeaker;
import devices.template.FirmwareUpdateTemplate;

public class SmartSpeakerFirmwareUpdate extends FirmwareUpdateTemplate
{
    private SmartSpeaker speaker;

    public SmartSpeakerFirmwareUpdate(SmartSpeaker speaker) {
        this.speaker = speaker;
    }

    @Override
    protected void prepareForUpdate() {
        System.out.println("Preparing " + speaker + " for firmware update (pausing playback).");
        speaker.stopMusic();
    }

    @Override
    protected String checkFirmwareVersion() {
        // In a real system, query the speaker
        String version = "1.0";
        System.out.println("Current firmware version: " + version);
        return version;
    }

    @Override
    protected String downloadFirmware(String currentVersion) {
        // In a real system, you'd download based on the device type and current version.
        String newFirmware = "1.1";
        System.out.println("Downloading firmware update " + newFirmware + " for version " + currentVersion);
        return newFirmware;
    }

    @Override
    protected void installFirmware(String firmware) {
        System.out.println("Installing firmware " + firmware + " on " + speaker);
    }

    @Override
    protected boolean verifyInstallation() {
        System.out.println("Verifying installation on " + speaker);
        return true;
    }

    @Override
    protected void rollbackUpdate() {
        System.out.println("Firmware update failed. Rolling back update on " + speaker);
    }
}
