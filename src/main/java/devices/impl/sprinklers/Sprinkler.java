package devices.impl.sprinklers;

import devices.state.SprinklerState;

// Tydzień 5, Wzorzec State
public class Sprinkler {
    private SprinklerState currentState;
    private int litersPerSquareMeter;

    public Sprinkler() {
        this.currentState = new OffState(this);
    }
    public void setState(SprinklerState state){
        this.currentState = state;
        System.out.println("Stan zraszacza zmieniony na: " + state.getClass().getSimpleName());
    }
    public void startWatering(){
        currentState.startWatering();
    }
    public void turnOffSprinkler(){
        currentState.turnOff();
    }
}
// Koniec Tydzień 5 Wzorzec State