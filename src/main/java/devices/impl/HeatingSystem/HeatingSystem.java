package devices.impl.HeatingSystem;

import devices.observer.Observer;

// Tydzien 5, Wzorzec Observer 1
public class HeatingSystem implements Observer<Integer> {
    private final int maxTemperatureToStartHeating = 20;
    @Override
    public void update(Integer value) {
        if (value < maxTemperatureToStartHeating) {
            System.out.println("Actual temperature: "+value+" Heating system ON.");
        } else {
            System.out.println("Actual temperature: "+value+" Heating system OFF.");
        }
    }
}
// Koniec Tydzień 5,Wzorzec Observer 1