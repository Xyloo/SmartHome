package devices.interpreter;

import devices.interpreter.expressions.*;

public class CommandParser {
    public static Expression parse(String command) {
        String[] tokens = command.split("\\s+");
        if (tokens.length < 1 || tokens[0].isBlank()) return null;

        switch (tokens[0].toUpperCase()) {
            case "TURN_ON":
                return parseTurnOn(tokens);
            case "SET_BRIGHTNESS":
                return parseSetBrightness(tokens);
            case "SET_VOLUME":
                return parseSetVolume(tokens);
            default:
                System.out.println("Unknown command: " + tokens[0]);
                return null;
        }
    }

    private static Expression parseTurnOn(String[] t) {
        return t.length >= 2
                ? new TurnOnExpression(t[1])
                : null;
    }

    private static Expression parseSetBrightness(String[] t) {
        if (t.length < 3) return null;
        try {
            return new SetBrightnessExpression(t[1], Integer.parseInt(t[2]));
        } catch (NumberFormatException e) {
            System.out.println("Invalid brightness: " + t[2]);
            return null;
        }
    }

    private static Expression parseSetVolume(String[] t) {
        if (t.length < 3) return null;
        try {
            return new SetSpeakerVolumeExpression(t[1], Integer.parseInt(t[2]));
        } catch (NumberFormatException e) {
            System.out.println("Invalid volume: " + t[2]);
            return null;
        }
    }
}
