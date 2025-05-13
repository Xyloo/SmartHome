package devices.impl.HeatingSystem;

import devices.observer.Observer;

// Tydzien 5, Wzorzec Observer 1
public class HeatingSystem implements Observer<Integer> {
    private final int maxTemperatureToStartHeating = 20;
    @Override
    public void update(Integer actualTemperature) {
        if (actualTemperature < maxTemperatureToStartHeating) {
            System.out.println("Actual temperature: "+actualTemperature+" Heating system ON.");
        } else {
            System.out.println("Actual temperature: "+actualTemperature+" Heating system OFF.");
        }
    }
}
// Koniec Tydzień 5,Wzorzec Observer 1