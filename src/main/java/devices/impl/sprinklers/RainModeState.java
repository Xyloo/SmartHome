package devices.impl.sprinklers;

import devices.state.SprinklerState;

public class RainModeState extends SprinklerState {
    private Sprinkler sprinkler;

    public RainModeState(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }

    @Override
    public void startWatering() {
        System.out.println("Zraszacz działa mimo deszczu.");
    }

    @Override
    public void turnOff() {
        System.out.println("Przerywamy zraszanie w deszczu. Zraszacz zostanie wyłączony.");
        sprinkler.setState(new OffState(sprinkler));
    }
}
