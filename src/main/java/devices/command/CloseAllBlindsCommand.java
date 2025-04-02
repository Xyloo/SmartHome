package devices.command;

import devices.impl.security.lockingsystem.SmartBlind;

import java.util.List;

public class CloseAllBlindsCommand implements Command {
    private List<SmartBlind> blinds;

    public CloseAllBlindsCommand(List<SmartBlind> blinds) {
        this.blinds = blinds;
    }

    @Override
    public void execute() {
        for (SmartBlind blind : blinds) {
            blind.close();
        }
    }

    @Override
    public void undo() {
        for (SmartBlind blind : blinds) {
            blind.open();
        }
    }
}
