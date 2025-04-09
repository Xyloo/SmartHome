package devices.impl.security.checks;

public class AwaySecurityCheck extends SecurityCheck {
    @Override
    protected void checkDoors() {
        System.out.println("Away mode: Deadbolts engaged on all exterior doors");
    }

    @Override
    protected void checkWindows() {
        System.out.println("Away mode: Ensuring all windows are fully closed and locked");
    }

    @Override
    protected void checkMotionSensors() {
        System.out.println("Away mode: Maximum sensitivity motion detection enabled");
        System.out.println("Away mode: Alert system armed for all zones");
    }

    @Override
    protected void checkCameras() {
        System.out.println("Away mode: Continuous recording enabled on all cameras");
        System.out.println("Away mode: Motion-activated alerts set to notify homeowner");
    }

    @Override
    protected void checkSmartLocks() {
        System.out.println("Away mode: Verifying smart locks have fresh batteries");
        System.out.println("Away mode: Activating vacation mode on smart locks");
    }
}