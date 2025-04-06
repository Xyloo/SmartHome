package devices.impl.HeatingSystem;

import devices.observer.Observer;

// Tydzien 5, Wzorzec Observer 1
public class CoolingSystem implements Observer<Integer> {
    @Override
    public void update(Integer value) {
        if (value > 25) {
            System.out.println("Actual temperature: "+value+" Cooling system ON.");
        } else {
            System.out.println("Actual temperature: "+value+" Cooling system OFF.");
        }
    }
}
//Koniec Tydzien 5, Wzorzec Observer 1