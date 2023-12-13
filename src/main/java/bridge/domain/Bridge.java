package bridge.domain;

import static bridge.constant.ExceptionConstant.BRIDGE_SIZE_STANDARD;
import static bridge.constant.NumberConstant.BRIDGE_SIZE_MAX;
import static bridge.constant.NumberConstant.BRIDGE_SIZE_MIN;

public class Bridge {

    private final int size;

    private Bridge(int size) {
        validateBridgeSize(size);
        this.size = size;
    }

    public static Bridge from(int size) {
        return new Bridge(size);
    }

    private void validateBridgeSize(int size) {
        if (BRIDGE_SIZE_MIN.getNumber() > size || BRIDGE_SIZE_MAX.getNumber() < size) {
            throw new IllegalArgumentException(BRIDGE_SIZE_STANDARD.getMessage());
        }
    }

    public int getSize() {
        return size;
    }
}
