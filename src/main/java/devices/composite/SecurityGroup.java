package devices.composite;

import devices.impl.security.SecurityCameraDevice;

public class SecurityGroup extends AbstractDeviceGroup implements SecurityCameraDevice {

    public SecurityGroup(int locationId){
        super(locationId);
    }


    @Override
    public void startRecording() {
        devices.forEach( device -> ((SecurityCameraDevice)device).startRecording ());
    }

    @Override
    public void stopRecording() {
        devices.forEach( device -> ((SecurityCameraDevice)device).stopRecording ());
    }

    @Override
    public void takeSnapshot() {
        devices.forEach( device -> ((SecurityCameraDevice)device).takeSnapshot ());
    }

    @Override
    public void setMotionDetectionEnabled( boolean enabled ) {
        devices.forEach( device -> ((SecurityCameraDevice)device).setMotionDetectionEnabled (enabled));
    }

    @Override
    public boolean isMotionDetectionEnabled() {
        return false;
    }

    @Override
    public void setAutoRecordingEnabled( boolean enabled ) {
        devices.forEach( device -> ((SecurityCameraDevice)device).setAutoRecordingEnabled (enabled));
    }

    @Override
    public boolean isAutoRecordingEnabled() {
        return false;
    }
}
