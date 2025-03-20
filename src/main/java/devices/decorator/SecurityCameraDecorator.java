package devices.decorator;

import devices.impl.security.SecurityCameraDevice;

//Tydzień 2, Wzorzec Decorator 2
public class SecurityCameraDecorator implements SecurityCameraDevice {
    protected SecurityCameraDevice decorated;
    public SecurityCameraDecorator(SecurityCameraDevice decorated) {
        this.decorated = decorated;
    }

    @Override
    public void startRecording() {
        decorated.startRecording();
    }

    @Override
    public void stopRecording() {
        decorated.stopRecording();
    }

    @Override
    public void takeSnapshot() {
        decorated.takeSnapshot();
    }

    @Override
    public void setMotionDetectionEnabled(boolean enabled) {
        decorated.setMotionDetectionEnabled(enabled);
    }

    @Override
    public boolean isMotionDetectionEnabled() {
        return false;
    }

    @Override
    public void setAutoRecordingEnabled(boolean enabled) {
        decorated.setAutoRecordingEnabled(enabled);
    }

    @Override
    public boolean isAutoRecordingEnabled() {
        return false;
    }

    @Override
    public void turnOn() {
        decorated.turnOn();
    }

    @Override
    public void turnOff() {
        decorated.turnOff();
    }

    @Override
    public String getStatus() {
        return decorated.getStatus();
    }
}
//Koniec Tydzień 2, Wzorzec Decorator 2