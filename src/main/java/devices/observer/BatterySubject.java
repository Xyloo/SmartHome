package devices.observer;

import java.util.ArrayList;
import java.util.List;


public class BatterySubject implements Subject {
    private final List<Observer<Integer>> observers = new ArrayList<>();
    private int batteryLevel = 100;

    public void setBatteryLevel(int level) {
        this.batteryLevel = level;
        notifyObservers();
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Integer> observer : observers) {
            observer.update(batteryLevel);
        }
    }

    public String getStatus() {
        return "Battery level: " + batteryLevel + "%";
    }
}
