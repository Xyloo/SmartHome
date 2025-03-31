package devices.command;

import java.util.ArrayList;
import java.util.List;

// Tydzien 4, Wzorzec Command 2
public class MacroCommand implements Command {
    List<Command> commands = new ArrayList<Command>();

    public MacroCommand() {
        util.SmartLogger.getInstance().log("Created a new MacroCommand");
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }

}
// Koniec Tydzien 4, Wzorzec Command 2