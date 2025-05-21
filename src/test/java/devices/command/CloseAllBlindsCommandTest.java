package devices.command;

import devices.impl.security.lockingsystem.SmartBlind;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloseAllBlindsCommandTest {
    private static class DummyBlind implements SmartBlind {
        boolean open = true;
        @Override public void open()  { open = true; }
        @Override public void setState(int coveringLevel, String mode) {}
        @Override public void close() { open = false; }
        @Override public void info()  { }
    }

    @Test
    void executeClosesAllAndUndoOpensAll() {
        DummyBlind b1 = new DummyBlind(), b2 = new DummyBlind();
        List<SmartBlind> blinds = Arrays.asList(b1, b2);
        CloseAllBlindsCommand cmd = new CloseAllBlindsCommand(blinds);

        assertTrue(b1.open);
        assertTrue(b2.open);

        cmd.execute();
        assertFalse(b1.open);
        assertFalse(b2.open);

        cmd.undo();
        assertTrue(b1.open);
        assertTrue(b2.open);
    }
}