package bridge.view;

import static bridge.constant.ExceptionConstant.INPUT_IS_ESSENTIAL;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVE_POSITION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_GAME_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printGameBegin() {
        System.out.println(PRINT_GAME_START);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        return printMessageAndGetInput(REQUEST_BRIDGE_SIZE);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return printMessageAndGetInput(REQUEST_MOVE_POSITION);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return printMessageAndGetInput(REQUEST_GAME_RESTART);
    }

    private String printMessageAndGetInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        validateBlank(userInput);
        return userInput;
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_ESSENTIAL.getMessage());
        }
    }
}
