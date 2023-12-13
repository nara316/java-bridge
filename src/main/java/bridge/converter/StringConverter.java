package bridge.converter;

public class StringConverter {

    public static int strToInt(String userInput, String errorMessage) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
