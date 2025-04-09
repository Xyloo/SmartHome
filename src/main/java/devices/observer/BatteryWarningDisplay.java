package devices.observer;

// Tydzień 5, Wzorzec Observer 2
public class BatteryWarningDisplay implements Observer<Integer> {
    @Override
    public void update(Integer batteryLevel) {
        if (batteryLevel < 20) {
            System.out.println("Warning: Low battery level (" + batteryLevel + "%)!");
        } else {
            System.out.println("Battery level is stable: " + batteryLevel + "%.");
        }
    }
}
// Koniec Tydzień 5, Wzorzec Observer 2