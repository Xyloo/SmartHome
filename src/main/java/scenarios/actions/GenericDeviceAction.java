package scenarios.actions;

import devices.impl.SmartDevice;
import util.SmartLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//Tydzień 4, Wzorzec Command 1
public class GenericDeviceAction<T extends SmartDevice> implements SmartAction {
    private final List<T> devices;
    private final Consumer<T> action;
    private final SmartLogger logger = SmartLogger.getInstance();

    public GenericDeviceAction(List<T> devices, Consumer<T> action) {
        this.devices = devices;
        this.action = action;
    }

    public GenericDeviceAction(T device, Consumer<T> action) {
        this.devices = new ArrayList<>();
        this.devices.add(device);
        this.action = action;
    }

    @Override
    public void execute() {
        for (T device : devices) {
            action.accept(device);
        }
        logger.log(this, "Executed action on " + devices.size() + " devices");
    }
}
//Koniec Tydzień 4, Wzorzec Command 1