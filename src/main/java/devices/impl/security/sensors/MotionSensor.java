package devices.impl.security.sensors;

import devices.impl.security.SecurityCamera;
import devices.mediator.SmartHomeMediator;
import devices.observer.Observer;
import devices.observer.Subject;

import java.util.ArrayList;
import java.util.List;

// konkretny czujnik
public class MotionSensor implements SecuritySensor, Subject{

    // stany wspólne dla każdego czujnika bezpieczeństwa
    private final String type;
    private final String model;
    private final String settings;
    private SmartHomeMediator mediator;
    private List<Observer> observers = new ArrayList<Observer>();

    public void setMediator(SmartHomeMediator mediator) {
        this.mediator = mediator;
    }

    public MotionSensor(String type, String model, String settings) {
        this.type = type;
        this.model = model;
        this.settings = settings;
    }

    @Override
    public void triggerAlarm(String location, boolean sendNotification) {
        System.out.println("ALARM! Czujnik "+model+" w lokalizacji: "+location+" wykrył podejrzany ruch!");

        if (mediator != null) {
            mediator.notify(this, "MOTION_DETECTED");
        }

        if(sendNotification){
            System.out.println("Czujnik "+model+" rozsyła powiadomienia.");
        }
    }

    @Override
    public void test() {
        System.out.println("Test czujnika: "+model+ " - "+type+" - "+settings);
    }

    @Override
    public void getStatus(boolean isActive, Integer batteryLevel, String location) {
        System.out.println("Czujnik: "+model+ " - "+type+" - "+settings+", lokalizacja: "+location+", stan: "+isActive+" bateria: "+batteryLevel);
    }

    public void triggerAlarm(String location){
        System.out.println("ALARM! Sensor " + model + " in location " + location + " detected suspicious motion!");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        if(!observers.contains(o)) {
            if(o instanceof SecurityCamera) {
                ((SecurityCamera)o).setMotionDetectionEnabled(true);
            }
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("MOTION_DETECTED");
        }
    }
}
