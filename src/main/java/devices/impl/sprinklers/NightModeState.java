package devices.impl.sprinklers;

import devices.state.SprinklerState;

public class NightModeState extends SprinklerState {

    private Sprinkler sprinkler;
    public NightModeState(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }
    @Override
    public void startWatering() {
        System.out.println("Zraszacz działa w trybie nocnym.");
    }

    @Override
    public void turnOff() {
        System.out.println("Przerywamy zraszanie nocne. Zraszacz zostaje wyłączony.");
        sprinkler.setState(new OffState(sprinkler));
    }
}
