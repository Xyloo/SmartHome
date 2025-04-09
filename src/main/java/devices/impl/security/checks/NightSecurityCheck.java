package devices.impl.security.checks;

public class NightSecurityCheck extends SecurityCheck {
    @Override
    protected void checkDoors() {
        System.out.println("Night mode: Verifying interior doors are unlocked");
        System.out.println("Night mode: Confirming exterior doors are locked");
    }

    @Override
    protected void checkWindows() {
        System.out.println("Night mode: Checking if any windows are open");
    }

    @Override
    protected void checkMotionSensors() {
        System.out.println("Night mode: Activating motion sensors with pet immunity");
    }

    @Override
    protected void checkCameras() {
        System.out.println("Night mode: Enabling night vision on all cameras");
    }
}