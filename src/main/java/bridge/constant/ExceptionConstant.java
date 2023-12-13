package bridge.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE.message + message;
    }
}