package devices.impl.security.checks;

// Tydzień 5 Wzorzec Template
public abstract class SecurityCheck {
    public final void performSecurityCheck() {
        checkDoors();
        checkWindows();
        checkMotionSensors();
        checkCameras();
        checkSmartLocks();
        generateReport();
    }

    // generating report is the same for all checks
    private void generateReport() {
        System.out.println("Generating security report...");
    }

    // custom implementation
    protected abstract void checkDoors();
    protected abstract void checkWindows();
    protected abstract void checkMotionSensors();

    // optional
    protected void checkCameras() {
        System.out.println("Standard camera check: Verifying feeds are active");
    }

    protected void checkSmartLocks() {
    }
}
// Koniec Tydzień 5 Wzorzec Template
