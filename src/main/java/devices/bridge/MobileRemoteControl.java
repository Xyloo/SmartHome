package devices.bridge;

import devices.command.Command;
import devices.impl.SmartDevice;
import devices.impl.lighting.Light;
import util.SmartLogger;

//Tydzień 2, Wzorzec Bridge 3
public class MobileRemoteControl extends AbstractRemoteControl {
    SmartLogger logger = SmartLogger.getInstance();
    Command mainCommand;
    boolean voiceControlEnabled = false;

    public MobileRemoteControl(SmartDevice device) {
        super(device);
    }

    // Additional mobile-specific behavior
    public void enableVoiceControl() {
        voiceControlEnabled = true;
        logger.log(this, "Voice control enabled for: " + device.getStatus());
    }

    public void disableVoiceControl()
    {
        voiceControlEnabled = false;
        logger.log(this, "Voice control disabled for: " + device.getStatus());
    }

    public void setBrightness(int brightness) {
        if(device instanceof Light){
            ((Light)device).setBrightness(brightness);
        }
        else{
            logger.log(this,"Device is not a light device!");
        }
    }

    public void setMainCommand(Command command)
    {
        this.mainCommand = command;
        logger.log(this,"Main command set to: " + command.getClass().getSimpleName());
    }

    public void pressMainButton()
    {
        if(mainCommand != null)
        {
            mainCommand.execute();
            logger.log(this,"Executing main command: " + mainCommand.getClass().getSimpleName());
        }
        else
        {
            logger.log(this,"No main command set!");
        }
    }

    @Override
    public void turnOff() {
        logger.log(this, "Turning off");
        device.turnOff();
    }

    @Override
    public void turnOn() {
        logger.log(this, "Turning on");
        device.turnOn();
    }

    @Override
    public String getStatus() {
        logger.log(this,"Getting status");
        return device.getStatus();
    }
}
//Koniec Tydzień 2, Wzorzec Bridge 3