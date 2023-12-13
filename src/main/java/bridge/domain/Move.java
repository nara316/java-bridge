package bridge.domain;

import static bridge.constant.ExceptionConstant.BRIDGE_MOVE_FORM;

import bridge.constant.BridgeConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Move {

    private final List<String> position;

    private Move() {
        position = new ArrayList<>();
    }

    public static Move from() {
        return new Move();
    }

    public List<String> addPositionByInput(String userInput) {
        if (!BridgeConstant.isCheckInBridgeConstant(userInput)) {
            throw new IllegalArgumentException(BRIDGE_MOVE_FORM.getMessage());
        }
        position.add(userInput);
        return position;
    }

    public List<String> getPosition() {
        return Collections.unmodifiableList(position);
    }
}
