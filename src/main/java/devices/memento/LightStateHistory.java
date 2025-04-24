package devices.memento;

import java.util.Stack;

public class LightStateHistory {
    private final Stack<LightMemento> history = new Stack<>();

    public void saveState(LightMemento memento) {
        history.push(memento);
    }

    public LightMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
