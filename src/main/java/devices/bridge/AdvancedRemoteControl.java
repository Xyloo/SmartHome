package devices.bridge;

import devices.impl.SmartDevice;
import devices.impl.lighting.Light;
import devices.impl.security.SecurityCamera;

//Tydzień 2, Wzorzec Bridge 1
public class AdvancedRemoteControl extends AbstractRemoteControl {

    public AdvancedRemoteControl(SmartDevice device) {
        super(device);
    }

    public void setBrightness(int brightness) {
        if(device instanceof Light){
            ((Light)device).setBrightness(brightness);
        }
        else{
            util.SmartLogger.getInstance().log("[AdvancedRemoteControl] Device is not a light device!");
        }
    }

    public void startRecording() {
        if(device instanceof SecurityCamera){
            ((SecurityCamera)device).startRecording();
        }
        else{
            util.SmartLogger.getInstance().log("[AdvancedRemoteControl] Device is not a light device!");
        }
    }

    @Override
    public void turnOff() {
        util.SmartLogger.getInstance().log("[AdvancedRemoteControl] Turning off");
        device.turnOff();
    }

    @Override
    public void turnOn() {
        util.SmartLogger.getInstance().log("[AdvancedRemoteControl] Turning on");
        device.turnOn();
    }

    @Override
    public String getStatus() {
        String status = device.getStatus();
        return "[AdvancedRemoteControl] " + status;
    }
}
//Koniec Tydzień 2, Wzorzec Bridge 1