package devices.memento;

import devices.impl.security.lockingsystem.Blind;

import java.util.Stack;

public class BlindsCaretaker {
    private final Stack<BlindsMemento> history = new Stack<>();

    public void save(Blind blinds) {
        history.push(blinds.saveState());
    }

    public void undo(Blind blinds) {
        if (!history.isEmpty()) {
            blinds.restoreState(history.pop());
        } else {
            System.out.println("states' history to backup is empty.");
        }
    }
}
