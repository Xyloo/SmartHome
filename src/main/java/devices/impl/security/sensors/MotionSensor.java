package devices.impl.security.sensors;

// konkretny czujnik
public class MotionSensor implements SecuritySensor{

    // stany wspólne dla każdego czujnika bezpieczeństwa
    private final String type;
    private final String model;
    private final String settings;

    public MotionSensor(String type, String model, String settings) {
        this.type = type;
        this.model = model;
        this.settings = settings;
    }

    @Override
    public void triggerAlarm(String location, boolean sendNotification) {
        System.out.println("ALARM! Czujnik "+model+" w lokalizacji: "+location+" wykrył podejrzany ruch!");
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
}
