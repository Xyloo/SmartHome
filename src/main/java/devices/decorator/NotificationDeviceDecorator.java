package devices.decorator;

import devices.impl.SmartDevice;
import notifications.NotificationGroup;

//Tydzień 2, Wzorzec Decorator 1
public class NotificationDeviceDecorator implements SmartDevice
{
    private SmartDevice device;
    private NotificationGroup group;

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
}
//Koniec Tydzień 2, Wzorzec Decorator 1