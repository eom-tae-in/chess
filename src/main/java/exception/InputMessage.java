package exception;

public enum InputMessage {

    WRONG_INPUT("올바르지 않은 입력입니다. 다시 입력해주세요.");

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
