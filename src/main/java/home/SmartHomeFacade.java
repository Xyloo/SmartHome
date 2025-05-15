package home;

import devices.impl.SecurityAlarm;
import devices.impl.SmartDevice;
import devices.impl.Thermostat;
import devices.impl.ThermostatConstants;
import devices.impl.lighting.Light;
import devices.impl.security.lockingsystem.Blind;
import devices.impl.security.sensors.MotionSensor;
import devices.mediator.SmartHomeMediator;
import notifications.NotificationGroup;
import scenarios.SmartScenario;
import scenarios.actions.GenericDeviceAction;
import scenarios.iterator.SmartScenarioIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SmartHomeFacade implements SmartHomeMediator {
    private final SmartHome smartHome;
    private final NotificationGroup notificationGroup;
    private List<SmartScenario> scenarios;

    public SmartHomeFacade(SmartHome smartHome, NotificationGroup notificationGroup) {
        this.smartHome = smartHome;
        this.notificationGroup = notificationGroup;
    }

    public SmartHomeFacade(SmartHome smartHome, NotificationGroup notificationGroup, List<SmartScenario> scenarios) {
        this.smartHome = smartHome;
        this.notificationGroup = notificationGroup;
        this.scenarios = scenarios;
    }

    public SmartHomeFacade(SmartHome smartHome, NotificationGroup notificationGroup, SmartScenario scenario) {
        this.smartHome = smartHome;
        this.notificationGroup = notificationGroup;
        this.scenarios = new ArrayList<>();
        scenarios.add(scenario);
    }

    public void activateNightMode() {
        performAction(Light.class, Light::turnOff);
        performAction(Thermostat.class, device -> device.setTemperature(ThermostatConstants.ECO_TEMPERATURE));
        performAction(SecurityAlarm.class, SecurityAlarm::turnOn);
        notificationGroup.send("Night mode activated.");
    }

    public void deactivateNightMode() {
        performAction(Light.class, Light::turnOn);
        performAction(Thermostat.class, device -> device.setTemperature(ThermostatConstants.COMFORTABLE_TEMPERATURE));
        performAction(SecurityAlarm.class, SecurityAlarm::turnOff);
        notificationGroup.send("Night mode deactivated.");
    }

    private <T extends SmartDevice> void performAction(Class<T> type, Consumer<T> action) {
        List<T> devices = smartHome.getDevicesOfType(type);
        new GenericDeviceAction<>(devices, action).execute();

    }

    private void addScenario(SmartScenario scenario) {
        scenarios.add(scenario);
    }

    // Tydzień 4, Wzorzec Iterator 3
    public void executeScenarios(List<String> scenarioNames) {
        SmartScenarioIterator iterator = new SmartScenarioIterator(scenarios, scenarioNames);

        if (!iterator.hasNext()) {
            System.out.println("No matching scenarios found.");
            return;
        }

        while (iterator.hasNext()) {
            SmartScenario scenario = iterator.next();
            scenario.execute(); // Execute the matched scenario
        }
    }
    // Koniec Tydzień 4, Wzorzec Iterator 3

    // Tydzien 4, Wzorzec Mediator 1
    @Override
    public void notify(Object sender, String event) {
        if(sender instanceof MotionSensor && event.equals("MOTION_DETECTED")){
            System.out.println("Motion sensor performs action");
            performAction(Light.class, Light::turnOn);
            performAction(SecurityAlarm.class, SecurityAlarm::turnOn);
        }
        else if(sender instanceof Blind && event.equals("NIGHT_MODE")){
            System.out.println("Night mode activated");
            activateNightMode();
        }
    }
    // Koniec Tydzien 4, Wzorzec Mediator 1
}