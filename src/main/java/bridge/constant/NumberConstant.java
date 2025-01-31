package bridge.constant;

public enum NumberConstant {

    BRIDGE_SIZE_MIN(3),
    BRIDGE_SIZE_MAX(20),
    BRIDGE_POSITION_DOWN(0),
    BRIDGE_POSITION_UP(1);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
