package devices.impl;

import devices.mediator.Mediator;
import devices.observer.Observer;
import devices.observer.Subject;
import devices.strategy.TemperatureControlStrategy;
import devices.visitor.SmartDeviceVisitor;
import util.SmartLogger;

import java.util.ArrayList;
import java.util.List;

public class Thermostat extends AbstractSmartDevice implements SmartDevice, Subject {
    private int temperature = 20; // default temperature
    private Mediator mediator;
    private List<Observer> observers = new ArrayList<>();
    private TemperatureControlStrategy strategy;

    @Override
    public void turnOn() {
        super.turnOn();
        temperature = 20;
    }

    @Override
    public void turnOff() {
        super.turnOff();
        temperature = 0;
    }

    @Override
    public String getStatus() {
        return (temperature == 0) ? "Thermostat is OFF" : "Thermostat is ON. Current temperature is " + temperature + " degrees";
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void Handle(String event) {
        if(event.equals("SET_TEMPERATURE_20")){
            setTemperature(20);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }

    // Tydzień 5, Wzorzec Observer 1
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
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
    // Koniec Tydzień 5 Observer 1

    // Tydzień 5, Wzorzec Strategy 1
    public void setStrategy(TemperatureControlStrategy strategy) {
        this.strategy = strategy;
    }

    public void adjustTemperature() {
        if (strategy != null) {
            strategy.adjustTemperature(this);
        } else {
            SmartLogger.getInstance().log(this, "Temperature control strategy not set.");
        }
    }
    // Koniec Tydzień 5, Wzorzec Strategy 1

    @Override
    public void acceptVisitor(SmartDeviceVisitor visitor)
    {
        visitor.visit(this);
    }
}

