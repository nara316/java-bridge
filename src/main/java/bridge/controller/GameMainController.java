package bridge.controller;

import static bridge.constant.GameConditionConstant.QUIT;
import static bridge.constant.GameConditionConstant.RESTART;

import bridge.BridgeMaker;
import bridge.constant.ExceptionConstant;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class GameMainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameMainController(
            InputView inputView, OutputView outputView, BridgeMaker bridgeMaker
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        inputView.printGameBegin();
        Bridge bridge = executeWithExceptionHandle(this::generateBridge);
        bridgeGame = new BridgeGame(bridge);
        proceedGame();
        outputView.printResult(bridgeGame.getResultGame());
    }

    private Bridge generateBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridgeRoad = bridgeMaker.makeBridge(size);
        return Bridge.of(size, bridgeRoad);
    }

    private void proceedGame() {
        boolean gameState = true;

        while (gameState) {
            gameMovement();
            gameState = isFail();
        }
    }

    private void gameMovement() {
        while (!bridgeGame.isFinish()) {
            try {
                outputView.printMap(bridgeGame.move(inputView.readMoving()));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private boolean isFail() {
        if (bridgeGame.isSuccess()) {
            return false;
        }

        return askRetry();
    }

    private boolean askRetry() {
        String inputValue = inputView.readGameCommand();

        try {
            validate(inputValue);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askRetry();
        }

        return isRetry(inputValue);
    }

    private boolean isRetry(String inputValue) {
        if (inputValue.equals(RESTART.getMessage())) {
            bridgeGame.retry();
            return true;
        }

        return false;
    }

    private void validate(String inputValue) {
        if (!inputValue.equals(QUIT.getMessage()) && !inputValue.equals(RESTART.getMessage())) {
            throw new IllegalArgumentException(ExceptionConstant.GAME_CONDITION_FORM.getMessage());
        }
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

