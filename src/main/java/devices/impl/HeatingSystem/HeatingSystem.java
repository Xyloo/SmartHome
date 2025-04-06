package devices.impl.HeatingSystem;

import devices.observer.Observer;

// Tydzien 5, Wzorzec Observer 1
public class HeatingSystem implements Observer<Integer> {
    @Override
    public void update(Integer value) {
        if (value < 20) {
            System.out.println("Actual temperature: "+value+" Heating system ON.");
        } else {
            System.out.println("Actual temperature: "+value+" Heating system OFF.");
        }
    }
}
// Koniec Tydzień 5,Wzorzec Observer 1