package devices.state;

import devices.impl.sprinklers.Sprinkler;

public abstract class SprinklerState {
    Sprinkler sprinkler;

    public abstract void startWatering();
    public abstract void turnOff();
}
