package devices.impl.sprinklers;

import devices.state.SprinklerState;

public class OffState extends SprinklerState {

    private Sprinkler sprinkler;

    public OffState(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }

    @Override
    public void startWatering() {
        System.out.println("Zraszacz się włącza... Uruchamiam podlewanie.");
        sprinkler.setState(new OnState(sprinkler));
    }
    public void turnOff() {
        System.out.println("Zraszacz jest już wyłączony.");
    }
}
