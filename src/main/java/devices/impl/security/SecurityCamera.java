package devices.impl.security;

import devices.impl.AbstractSmartDevice;
import devices.configs.SecurityCameraConfig;
import devices.mediator.Mediator;
import devices.observer.Observer;
import util.DeviceManager;

import java.util.UUID;

public class SecurityCamera extends AbstractSmartDevice implements SecurityCameraDevice, Observer {
    public static final String CONFIG_KEY = "SecurityCamera";
    private boolean isRecording;
    private boolean isMotionDetectionEnabled;
    private boolean isAutoRecordingEnabled;
    private Mediator mediator;

    public SecurityCamera() {
        SecurityCameraConfig config = DeviceManager.INSTANCE.getSetting(CONFIG_KEY, SecurityCameraConfig.class);
        isRecording = config.isRecording();
    }
    public SecurityCamera(int locationId){
        super(locationId);
    }

    //zmienic konstruktor ewentualnie oddzielna methoda wrzucajaca konfig oddzielnie
    // do kazdego konstrutkora???

    @Override
    public void turnOff(){
        stopRecording();
        super.turnOff();
    }

    @Override
    public String getStatus() {
        return "Security Camera " +
                "is " + (isRecording ? "recording" : "idle") +
                ", id = " + id +
                ", isRecording = " + isRecording +
                ", isMotionDetectionEnabled = " + isMotionDetectionEnabled +
                ", isAutoRecordingEnabled = " + isAutoRecordingEnabled;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        System.out.println("Camera handling event: " + event);
        if(event.equals("CAMERA_SNAPSHOT")){
            System.out.println("Security camera - taking snapshot");
            takeSnapshot();
        }else if(event.equals("activateSecurityMode")){
            util.SmartLogger.getInstance ().log ("[Security camera] - turning on, start recording ");
            turnOn();
            startRecording();
        }
        if(event.equals("LIGHT_TURN_OFF")){
            // symulacja trybu nocnego
            System.out.println("Security camera - lights turned off. Camera night mode activated.");
        }
        else if(event.equals("deactivateSecurityMode")){
            util.SmartLogger.getInstance ().log ("[Security camera] - stop recording, taking snapshot ");
            stopRecording();
            takeSnapshot();
            turnOff();
        }
    }

    @Override
    public void startRecording() {  isRecording = true; }

    @Override
    public void stopRecording() { isRecording = false; }

    @Override
    public void takeSnapshot() {
        util.SmartLogger.getInstance().log ("SecurityCamera " + id +"created snapshot: " + UUID.randomUUID());
    }

    @Override
    public void setMotionDetectionEnabled( boolean enabled ) { isMotionDetectionEnabled = enabled; }

    @Override
    public boolean isMotionDetectionEnabled() { return isMotionDetectionEnabled; }

    @Override
    public void setAutoRecordingEnabled( boolean enabled ) { isAutoRecordingEnabled = enabled; }

    @Override
    public boolean isAutoRecordingEnabled() { return isAutoRecordingEnabled; }

    @Override
    public void update(Object value) {
        if(value instanceof String && value.equals("MOTION_DETECTED")) {
            turnOn();
            startRecording();
        }
    }
}

