package devices.composite;


import devices.impl.lighting.LightingDevice;

//Tydzień 2, Wzorzec Composite 1
public class LightingGroup extends AbstractDeviceGroup implements LightingDevice {

    public LightingGroup() {
        super();
        util.SmartLogger.getInstance ().log ("LightingGroup instance created " + this.id);
    }

    public LightingGroup(int locationId) {
        super(locationId);
        util.SmartLogger.getInstance ().log ("LightingGroup instance created " + this.id + " at location " + locationId);
    }

    @Override
    public void setBrightness( int brightness ) {
        devices.forEach(device -> ((LightingDevice) device).setBrightness(brightness));
    }

    @Override
    public int getBrightness() {
        return 0;
    }
}
//Koniec Tydzień 2, Wzorzec Composite 1