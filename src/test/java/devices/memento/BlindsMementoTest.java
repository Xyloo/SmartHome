package devices.memento;

import devices.impl.security.lockingsystem.Blind;
import devices.impl.security.lockingsystem.BlindType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlindsMementoTest {

    @Test
    void testBlindsStateSaveAndRestore() {
        Blind blind = new Blind(new BlindType("black", "secure", ""),"Living Room");
        BlindsCaretaker caretaker = new BlindsCaretaker();

        blind.close();
        caretaker.save(blind);

        blind.open(); // closed
        assertTrue(blind.isOpen(), "Blind should be open");

        // Restore previous state
        caretaker.undo(blind);

        assertFalse(blind.isOpen(), "Blind should be closed");
    }

    @Test
    void testBlindsStateSaveAndRestoreWithMultipleStates() {
        Blind blind = new Blind(new BlindType("black", "secure", ""),"Living Room");
        BlindsCaretaker caretaker = new BlindsCaretaker();

        blind.close();
        caretaker.save(blind);

        blind.open(); // closed
        caretaker.save(blind);
        assertTrue(blind.isOpen(), "Blind should be open");

        blind.close(); // closed
        assertFalse(blind.isOpen(), "Blind should be closed");

        // Restore previous state
        caretaker.undo(blind);
        assertTrue(blind.isOpen(), "Blind should be open");

        // Restore to the first saved state
        caretaker.undo(blind);
        assertFalse(blind.isOpen(), "Blind should be closed");
    }

    @Test
    void testCoveringLevelMemento() {
        Blind blind = new Blind(new BlindType("black", "secure", ""),"Living Room");
        BlindsCaretaker caretaker = new BlindsCaretaker();

        blind.setCoveringLevel(50);
        caretaker.save(blind);

        blind.setCoveringLevel(100); // closed
        assertEquals(100, blind.getCoveringLevel(), "Blind covering level should be 100");

        // Restore previous state
        caretaker.undo(blind);

        assertEquals(50, blind.getCoveringLevel(), "Blind covering level should be 50");
    }
}