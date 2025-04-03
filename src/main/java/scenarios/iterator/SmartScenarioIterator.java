package scenarios.iterator;

import scenarios.SmartScenario;

import java.util.List;

public class SmartScenarioIterator {
    private List<SmartScenario> scenarios;
    private List<String> scenarioNames;
    private int currentIndex = 0;

    public SmartScenarioIterator(List<SmartScenario> scenarios, List<String> scenarioNames) {
        this.scenarios = scenarios;
        this.scenarioNames = scenarioNames;
    }

    public boolean hasNext() {
        while (currentIndex < scenarios.size()) {
            SmartScenario scenario = scenarios.get(currentIndex);
            if (scenarioNames.contains(scenario.getName())) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    public SmartScenario next() {
        if (this.hasNext()) {
            return scenarios.get(currentIndex++);
        }
        return null;
    }
}
