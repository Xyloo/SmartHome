package util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class SmartLoggerTest {

    @Test
    void testSingletonInstanceIsSame() {
        SmartLogger logger1 = SmartLogger.getInstance();
        SmartLogger logger2 = SmartLogger.getInstance();

        assertSame(logger1, logger2, "Expected the same instance (singleton)");
    }

    @Test
    void testLogWithObjectOutputsClassName() {
        SmartLogger logger = SmartLogger.getInstance();

        // Capture console output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        DummyObject dummy = new DummyObject();
        logger.log(dummy, "Test message");

        String expected = "LOG: [DummyObject]: Test message";
        String actual = outContent.toString().trim();

        assertEquals(expected, actual);
    }

    // Helper dummy class
    static class DummyObject {}
}
