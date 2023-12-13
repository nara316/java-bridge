package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.Move;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(
            InputView inputView, OutputView outputView, BridgeMaker bridgeMaker
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        inputView.printGameBegin();
        Bridge bridge = executeWithExceptionHandle(this::generateBridge);
        Move move = Move.from();
        move(move, bridge);
    }

    private Bridge generateBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridgeRoads = bridgeMaker.makeBridge(size);
        return Bridge.of(size, bridgeRoads);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Move move, Bridge bridge) {
        while (true) {
            List<String> movePosition = addMoveByUserInput(move);
            if (!isMovePositionMatchBridgeRoads(movePosition, bridge)) {
                break;
            }
            if (isCheckGameEnd(movePosition, bridge)) {
                break;
            }
        }
    }

    private List<String> addMoveByUserInput(Move move) {
        return executeWithExceptionHandle(() -> {
            String userInput = inputView.readMoving();
            return move.addPositionByInput(userInput);
        });
    }

    private boolean isMovePositionMatchBridgeRoads(List<String> movePosition, Bridge bridge) {
        return IntStream.range(0, movePosition.size())
                .allMatch(i -> bridge.getBridgeRoad().get(i).equals(movePosition.get(i)));
    }

    private boolean isCheckGameEnd(List<String> movePosition, Bridge bridge) {
        return movePosition.size() == bridge.getBridgeRoad().size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private static <T> T executeWithExceptionHandle (final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
