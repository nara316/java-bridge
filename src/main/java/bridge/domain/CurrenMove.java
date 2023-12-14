package bridge.domain;

import static bridge.constant.BridgeConstant.BRIDGE_DOWN;
import static bridge.constant.BridgeConstant.BRIDGE_UP;
import static bridge.constant.PrintConstant.BLANK;
import static bridge.constant.PrintConstant.CAN_MOVE;
import static bridge.constant.PrintConstant.CAN_NOT_MOVE;
import static bridge.constant.PrintConstant.DIVISION_STANDARD;

import java.util.ArrayList;
import java.util.List;

public class CurrenMove {

    private static final String BRIDGE_STANDARD = "[%s]\n[%s]\n";

    private final List<String> upBridge;
    private final List<String> downBridge;

    private CurrenMove() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public static CurrenMove from() {
        return new CurrenMove();
    }

    public String getCurrentBridgeMove(String userMove, boolean isCorrectAnswer) {
        updateUpBridge(userMove, isCorrectAnswer);
        updateDownBridge(userMove, isCorrectAnswer);
        return getBridgeMove();
    }

    private void updateUpBridge(String userMove, boolean isCorrectAnswer) {
        if (userMove.equals(BRIDGE_UP.getMessage()) && isCorrectAnswer) {
            upBridge.add(CAN_MOVE.getMessage());
            downBridge.add(BLANK.getMessage());
            return;
        }
        if (userMove.equals(BRIDGE_UP.getMessage())) {
            upBridge.add(CAN_NOT_MOVE.getMessage());
            downBridge.add(BLANK.getMessage());
        }
    }

    private void updateDownBridge(String userMove, boolean isCorrectAnswer) {
        if (userMove.equals(BRIDGE_DOWN.getMessage()) && isCorrectAnswer) {
            downBridge.add(CAN_MOVE.getMessage());
            upBridge.add(BLANK.getMessage());
            return;
        }
        if (userMove.equals(BRIDGE_DOWN.getMessage())) {
            downBridge.add(CAN_NOT_MOVE.getMessage());
            upBridge.add(BLANK.getMessage());
        }
    }

    public String getBridgeMove() {
        return String.format(BRIDGE_STANDARD,String.join(DIVISION_STANDARD.getMessage(), upBridge),
                String.join(DIVISION_STANDARD.getMessage(), downBridge));
    }
}
