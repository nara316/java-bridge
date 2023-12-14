package bridge.constant;

import java.util.Arrays;

public enum GameConditionConstant {

    RESTART("R"),
    QUIT("Q");

    private final String message;

    GameConditionConstant(String message) {
        this.message = message;
    }

    public static boolean isCheckInGameConditionConstant(String userInput) {
        return Arrays.stream(GameConditionConstant.values())
                .anyMatch(gameConditionConstant -> gameConditionConstant.message.equals(userInput));
    }

    public String getMessage() {
        return message;
    }
}
