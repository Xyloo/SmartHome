package devices.composite;

import devices.impl.security.SecurityCameraDevice;
import devices.mediator.Mediator;

//Tydzień 2, Wzorzec Composite 2
public class SecurityGroup extends AbstractDeviceGroup implements SecurityCameraDevice {

    private Mediator mediator;

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

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("RECORDING_START_GROUP")){
            startRecording();
        }
    }
}
//Koniec Tydzień 2, Wzorzec Composite 2