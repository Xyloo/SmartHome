package devices.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MacroCommandTest {
    private static class DummyCmd implements Command {
        boolean executed = false;
        boolean undone   = false;
        @Override public void execute() { executed = true; }
        @Override public void undo()    { undone   = true; }
    }

    @Test
    void executeRunsAllAndUndoRunsAll() {
        DummyCmd command1 = new DummyCmd(), c2 = new DummyCmd();
        MacroCommand macro = new MacroCommand();
        macro.addCommand(command1);
        macro.addCommand(c2);

        macro.execute();
        assertTrue(command1.executed);
        assertTrue(c2.executed);

        macro.undo();
        assertTrue(command1.undone);
        assertTrue(c2.undone);
    }
}