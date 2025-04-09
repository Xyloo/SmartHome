package devices.impl.sprinklers;

import devices.state.SprinklerState;

public class AutomaticState extends SprinklerState {
    private Sprinkler sprinkler;
    public AutomaticState(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }
    @Override
    public void startWatering() {
        System.out.println("Zraszacz działa automatycznie, dostosowując się do warunków pogodowych.");
    }

    @Override
    public void turnOff() {
        System.out.println("Zraszacz zostaje wyłączony.");
        sprinkler.setState(new OffState(sprinkler));
    }
}
