package bridge;

import bridge.controller.GameMainController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameMainController gameMainController = new GameMainController(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        );
        gameMainController.run();
    }
}
