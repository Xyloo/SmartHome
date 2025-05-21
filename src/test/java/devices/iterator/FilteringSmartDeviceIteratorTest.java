package devices.iterator;

import devices.impl.SmartDevice;
import devices.mediator.Mediator;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class FilteringSmartDeviceIteratorTest {

    private static class TestDevice implements SmartDevice {
        private final boolean active;
        private int id;

        boolean turnedOn = false;
        boolean turnedOff = false;
        TestDevice(boolean active) { this.active = active; }
        TestDevice(boolean active, int id) { this.active = active; this.id = id; }
        boolean isActive() { return active; }
        @Override public void turnOn() { turnedOn = true; }
        @Override public void turnOff() { turnedOff = true; }
        @Override public String getStatus() { return active ? "ON" : "OFF";}
        @Override public void setMediator(Mediator mediator) {}
        @Override public void handle(String event) {}
        public int getId() { return id;}
    }

    @Test
    void emptyList_hasNextFalse_nextThrows() {
        List<SmartDevice> empty = Collections.emptyList();
        FilteringSmartDeviceIterator it =
                new FilteringSmartDeviceIterator(empty.iterator(),
                        d -> true);

        assertFalse(it.hasNext(), "No elements at all");
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void noMatch_hasNextFalse() {
        List<SmartDevice> list = List.of(
                new TestDevice(false),
                new TestDevice(false)
        );
        Predicate<SmartDevice> onlyOn = d -> ((TestDevice)d).isActive();
        FilteringSmartDeviceIterator it =
                new FilteringSmartDeviceIterator(list.iterator(), onlyOn);

        assertFalse(it.hasNext(), "All devices are OFF, so no match");
    }

    @Test
    void filterSelectsOnlyActiveDevices() {
        TestDevice d1 = new TestDevice(true);
        TestDevice d2 = new TestDevice(false);
        TestDevice d3 = new TestDevice(true);
        List<SmartDevice> list = List.of(d1, d2, d3);

        Predicate<SmartDevice> onlyOn = d -> ((TestDevice)d).isActive();
        FilteringSmartDeviceIterator it =
                new FilteringSmartDeviceIterator(list.iterator(), onlyOn);

        assertTrue(it.hasNext());
        assertSame(d1, it.next());
        assertTrue(it.hasNext());
        assertSame(d3, it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void predicateSkipsNonMatches() {

        TestDevice d1 = new TestDevice(true, 1);
        TestDevice d2 = new TestDevice(true, 2);
        TestDevice d3 = new TestDevice(true, 3);

        List<SmartDevice> list = Arrays.asList(d1, d2, d3);
        Predicate<SmartDevice> oddId = d -> ((TestDevice)d).getId() % 2 == 1;
        FilteringSmartDeviceIterator it =
                new FilteringSmartDeviceIterator(list.iterator(), oddId);

        assertTrue(it.hasNext());
        assertSame(d1, it.next());
        assertTrue(it.hasNext());
        assertSame(d3, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void remove_removesTheUnderlyingElement() {
        TestDevice d1 = new TestDevice(true);
        TestDevice d2 = new TestDevice(true);
        List<SmartDevice> list = new ArrayList<>(List.of(d1, d2));

        FilteringSmartDeviceIterator it =
                new FilteringSmartDeviceIterator(list.iterator(), d -> true);

        assertSame(d1, it.next());
        it.remove();
        assertEquals(1, list.size(), "Exactly one element should remain");
        assertSame(d1, list.get(0), "The remaining element must be d1");
    }

}