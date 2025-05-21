package devices.impl;

import devices.memento.ThermostatMemento;
import devices.strategy.TemperatureControlStrategy;
import devices.observer.Observer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {

    @Test
    void testTurnOnAndTurnOff() {
        Thermostat thermo = new Thermostat();
        thermo.turnOn();
        assertTrue(thermo.getStatus().contains("ON"),
                "Po wywołaniu turnOn() status powinien zawierać ON");
        assertEquals(ThermostatConstants.DEFAULT_TEMPERATURE, thermo.getTemperature(),
                "Po włączeniu temperatura powinna być DEFAULT_TEMPERATURE");

        thermo.turnOff();
        assertTrue(thermo.getStatus().contains("OFF"),
                "Po wywołaniu turnOff() status powinien zawierać OFF");
        assertEquals(ThermostatConstants.THERMOSTAT_OFF, thermo.getTemperature(),
                "Po wyłączeniu temperatura powinna być THERMOSTAT_OFF");
    }

    @Test
    void testHandleEventSetTemperature20() {
        Thermostat thermo = new Thermostat();

        thermo.setTemperature(25);
        assertEquals(25, thermo.getTemperature());

        thermo.handle("SET_TEMPERATURE_20");
        assertEquals(ThermostatConstants.DEFAULT_TEMPERATURE, thermo.getTemperature(),
                "Po obsłudze eventu SET_TEMPERATURE_20 temperatura powinna być DEFAULT_TEMPERATURE");
    }

    @Test
    void testObserverNotification() {
        Thermostat thermo = new Thermostat();
        class DummyObserver implements Observer<Integer> {
            Integer last = null;
            @Override
            public void update(Integer data) {
                last = data;
            }
        }
        DummyObserver obs = new DummyObserver();
        thermo.registerObserver(obs);

        thermo.setTemperature(30);
        assertEquals(30, obs.last,
                "Observer powinien otrzymać zaktualizowaną temperaturę 30");

        thermo.removeObserver(obs);
        thermo.setTemperature(35);
        assertEquals(30, obs.last,
                "Po usunięciu observer nie powinno być kolejnej aktualizacji");
    }

    @Test
    void testStrategyAdjustTemperature() {
        Thermostat thermo = new Thermostat();

        TemperatureControlStrategy strategy = t -> t.setTemperature(15);
        thermo.setStrategy(strategy);

        thermo.setTemperature(25);
        thermo.adjustTemperature();
        assertEquals(15, thermo.getTemperature(),
                "Strategia powinna ustawić temperaturę na 15");
    }

    @Test
    void testTriggerAlarmPrintsMessage() {
        Thermostat thermo = new Thermostat();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        thermo.triggerAlarm();
        String printed = out.toString().trim();
        assertEquals("Thermostat raises alarm!", printed,
                "triggerAlarm() powinien wypisać komunikat alarmu");
    }

    @Test
    void testMementoSaveRestore() {
        Thermostat thermo = new Thermostat();

        thermo.turnOn();
        thermo.setTemperature(ThermostatConstants.COMFORTABLE_TEMPERATURE);

        ThermostatMemento memento = thermo.saveState();

        thermo.turnOff();
        thermo.setTemperature(ThermostatConstants.ECO_TEMPERATURE);
        assertNotEquals(memento.temperature(), thermo.getTemperature(),
                "Temperatura po zmianie nie powinna być równa zapisanej w memento");

        thermo.restoreState(memento);
        assertTrue(thermo.getStatus().contains("ON"),
                "Po przywróceniu stanu urządzenie powinno być włączone");
        assertEquals(
                ThermostatConstants.COMFORTABLE_TEMPERATURE,
                thermo.getTemperature(),
                "Po przywróceniu stanu temperatura powinna być taka sama jak w memento"
        );
    }
}
