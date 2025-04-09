package devices.impl.sprinklers;

import devices.state.SprinklerState;

public class OnState extends SprinklerState {
    private Sprinkler sprinkler;

    public OnState(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }
    @Override
    public void startWatering() {
        System.out.println("Zraszacz już działa. Podlewam ogród.");
    }

    @Override
    public void turnOff() {
        System.out.println("Zraszacz zostaje wyłączony.");
        sprinkler.setState(new OffState(sprinkler));
    }
}
