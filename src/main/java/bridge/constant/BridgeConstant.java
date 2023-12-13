package bridge.constant;

public enum BridgeConstant {

    BRIDGE_UP("U"),
    BRIDGE_DOWN("D");

    private final String message;

    BridgeConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
