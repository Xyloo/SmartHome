package devices.observer;

// Tydzień 5, Wzorzec Observer 2
public class BatteryWarningDisplay implements Observer<Integer> {
    private final int warningBatteryLevel = 20;
    @Override
    public void update(Integer batteryLevel)
    {
        if (batteryLevel < warningBatteryLevel)
        {
            System.out.println("Warning: Low battery level (" + batteryLevel + "%)!");
        } else
        {
            System.out.println("Battery level is stable: " + batteryLevel + "%.");
        }
    }
}
// Koniec Tydzień 5, Wzorzec Observer 2