package devices.interpreter;

import devices.interpreter.expressions.SetBrightnessExpression;
import devices.interpreter.expressions.TurnOnExpression;

public class CommandParser {
    public static Expression parse(String command) {
        String[] tokens = command.split("\\s+");
        if (tokens.length == 0) {
            return null;
        }
        String keyword = tokens[0].toUpperCase();
        switch (keyword) {
            case "TURN_ON":
                if (tokens.length >= 2) {
                    return new TurnOnExpression(tokens[1]);
                }
                break;
            case "SET_BRIGHTNESS":
                if (tokens.length >= 3) {
                    try {
                        int brightness = Integer.parseInt(tokens[2]);
                        return new SetBrightnessExpression (tokens[1], brightness);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid brightness value: " + tokens[2]);
                    }
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
        return null;
    }
}
