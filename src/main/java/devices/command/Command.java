package devices.command;

public interface Command {
    void execute();
    void undo();
}
