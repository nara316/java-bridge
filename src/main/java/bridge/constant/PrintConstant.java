package bridge.constant;

public enum PrintConstant {

    CAN_MOVE(" O "),
    CAN_NOT_MOVE(" X "),
    BLANK("   "),
    DIVISION_STANDARD("|");

    private final String message;

    PrintConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
