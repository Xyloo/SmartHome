package devices.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BatteryObserverTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testBatteryWarningReceivesUpdate() {
        BatterySubject battery = new BatterySubject();
        BatteryWarningDisplay display = new BatteryWarningDisplay();

        battery.registerObserver(display);
        battery.setBatteryLevel(15); // below threshold

        String output = outContent.toString().trim();
        assertTrue(output.contains("Warning: Low battery level (15%)"), "Should print warning for low battery");

        outContent.reset();
        battery.setBatteryLevel(85); // above threshold

        output = outContent.toString().trim();
        assertTrue(output.contains("Battery level is stable: 85%"), "Should print stable battery message");
    }

    @Test
    void testBatteryWarningInitialStatus() {
        BatteryWarningDisplay display = new BatteryWarningDisplay();
        display.update(50); // simulate update

        String output = outContent.toString().trim();
        assertTrue(output.contains("Battery level is stable: 50%"), "Initial message should reflect battery level");
    }
}