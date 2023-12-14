package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.CurrenMove;
import bridge.domain.Move;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String SUCCESS_MESSAGE = "\n게임 성공 여부: 성공\n";
    private static final String FAIL_MESSAGE = "\n게임 성공 여부: 실패\n";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";

    private int tryCount;
    private final Bridge bridge;
    private CurrenMove currenMove;
    private Move move;

    public BridgeGame(Bridge bridge) {
        this.tryCount = 1;
        this.bridge = bridge;
        this.currenMove = CurrenMove.from();
        this.move = Move.from();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String userInput) {
        move.addPositionByInput(userInput);
        return currenMove.getCurrentBridgeMove(userInput, isCheckEqual());
    }

    private boolean isCheckEqual() {
        return bridge.isAllEqual(move.getPosition());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        move = Move.from();
        currenMove = CurrenMove.from();
    }

    public boolean isFinish() {
        if (isEndBridge()) {
            return true;
        }
        if (move.getPosition().size() == 0) {
            return false;
        }

        return !isCheckEqual();
    }

    private boolean isEndBridge() {
        return bridge.getBridgeRoad().size() == move.getPosition().size();
    }

    public String getResultGame() {
        return getResultBridgeMap() + getResultSuccessOrFail() + getResultTry();
    }

    public boolean isSuccess() {
        return bridge.isAllEqual(move.getPosition());
    }

    private String getResultBridgeMap() {
        return currenMove.getBridgeMove();
    }

    private String getResultSuccessOrFail() {
        if (isEndBridge()) {
            return SUCCESS_MESSAGE;
        }
        return FAIL_MESSAGE;
    }

    private String getResultTry() {
        return String.format(TOTAL_TRY_COUNT_MESSAGE, tryCount);
    }
}
