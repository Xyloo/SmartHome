package devices.interpreter;

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
            default:
                System.out.println("Unknown command: " + command);
        }
        return null;
    }
}
