package bridge.constant;

import java.util.Arrays;

public enum BridgeConstant {

    BRIDGE_UP("U"),
    BRIDGE_DOWN("D");

    private final String message;

    BridgeConstant(String message) {
        this.message = message;
    }

    public static boolean isCheckInBridgeConstant(String userInput) {
        return Arrays.stream(BridgeConstant.values())
                .anyMatch(bridgeConstant -> bridgeConstant.message.equals(userInput));
    }

    public String getMessage() {
        return message;
    }
}
