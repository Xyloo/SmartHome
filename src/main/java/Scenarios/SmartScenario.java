package Scenarios;

import java.util.ArrayList;
import java.util.List;

//Tydzień 2, Wzorzec Composite 3
public class SmartScenario implements SmartAction {
    private final String name;
    private final List<SmartAction> actions;

    private SmartScenario(Builder builder) {
        this.name = builder.name;
        this.actions = builder.actions;
    }

    @Override
    public void execute() {
        System.out.println("Executing scenario: " + name);
        for (SmartAction action : actions) {
            action.execute();
        }
    }

    public static class Builder {
        private String name;
        private List<SmartAction> actions = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addAction(SmartAction action) {
            actions.add(action);
            return this;
        }

        public SmartScenario build() {
            return new SmartScenario(this);
        }
    }
}
//Koniec Tydzień 2, Wzorzec Composite 3