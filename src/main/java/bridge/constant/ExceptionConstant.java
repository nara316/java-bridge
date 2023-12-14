package bridge.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    BRIDGE_SIZE_STANDARD("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_INPUT_FORM("다리 길이에 대한 입력값은 숫자만 허용합니다."),
    BRIDGE_MOVE_FORM("이동에 대한 입력값은 (위: U, 아래: D)만을 허용합니다."),
    GAME_CONDITION_FORM("게임 진행에 대한 입력값은 (재시작: R, 종료: Q)만을 허용합니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE.message + message;
    }
}