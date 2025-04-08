package devices.template;

// Tydzień 5, Wzorzec Template 1
public abstract class FirmwareUpdateTemplate {
    // Template method: Do not override
    public final void performFirmwareUpdate() {
        prepareForUpdate();
        String currentVersion = checkFirmwareVersion();
        String newFirmware = downloadFirmware(currentVersion);
        installFirmware(newFirmware);
        if (verifyInstallation()) {
            updateComplete();
        } else {
            rollbackUpdate();
        }
    }

    // Steps that each subclass must implement.
    protected abstract void prepareForUpdate();
    protected abstract String checkFirmwareVersion();
    protected abstract String downloadFirmware(String currentVersion);
    protected abstract void installFirmware(String firmware);
    protected abstract boolean verifyInstallation();
    protected abstract void rollbackUpdate();

    // A common final step (hook) with default behavior.
    protected void updateComplete() {
        System.out.println("Firmware update completed successfully.");
    }
}
// Koniec Tydzień 5, Wzorzec Template 1
