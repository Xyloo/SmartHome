package devices.decorator;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;
import notifications.NotificationGroup;

//Tydzień 2, Wzorzec Decorator 1
public class NotificationDeviceDecorator implements SmartDevice
{
    private SmartDevice device;
    private NotificationGroup group;
    private Mediator mediator;

    public NotificationDeviceDecorator(SmartDevice device, NotificationGroup group)
    {
        this.device = device;
        this.group = group;
    }

    @Override
    public void turnOn()
    {
        device.turnOn();
        group.send("Device " + device.getClass().getSimpleName() + " was just turned on");
    }

    @Override
    public void turnOff()
    {
        device.turnOff();
        group.send("Device " + device.getClass().getSimpleName() + " was just turned off");
    }

    @Override
    public String getStatus()
    {
        return device.getStatus();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void handle(String event) {
        if(event.equals("NOTIFICATION_DEVICE_ON")){
            turnOn();
        }
    }
}
//Koniec Tydzień 2, Wzorzec Decorator 1