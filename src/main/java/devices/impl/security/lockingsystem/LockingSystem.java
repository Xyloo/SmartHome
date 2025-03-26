package devices.impl.security.lockingsystem;

import devices.factory.LockingSystemFactory;
import java.util.ArrayList;
import java.util.List;

//Tydzień 2, Wzorzec Flyweight 2
public class LockingSystem {
    private List<SmartBlind> blinds = new ArrayList<>();

    public void installBlind(String location, String type, String color, String anyOtherParameter) {
        BlindType blindType = LockingSystemFactory.getBlinds(type,color,anyOtherParameter);
        SmartBlind blind = new Blind(blindType,location);
        System.out.println("Zainstalowano nową roletę typu " + blindType.type + " w lokalizacji: "+ location);
        blinds.add(blind);
    }

    public void openAll() {
        System.out.println("\nOdsłanianie wszystkich rolet:");
        for(SmartBlind blind : blinds){
            blind.open();
        }
    }

    public void closeAll() {
        System.out.println("\nZasłanianie wszystkich rolet:");
        for(SmartBlind blind : blinds){
            blind.close();
        }
    }

    public void listDevices() {
        System.out.println("\nLista rolet:");
        for (SmartBlind blind : blinds) {
            blind.info();
        }
    }
}
// Koniec Tydzień 2, Wzorzec Flyweight 2