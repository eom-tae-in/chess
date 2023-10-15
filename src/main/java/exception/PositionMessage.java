package exception;

public enum PositionMessage {
    
    POSITION_NOT_FOUND_EXCEPTION("해당 위치를 찾지 못했습니다."),
    ROW_NOT_FOUND_EXCEPTION("행의 값은 a ~ h까지 입니다."),
    COLUMN_NOT_FOUND_EXCEPTION("열의 값은 1 ~ 8까지 입니다."),
    POSITION_CAN_NOT_MOVE_EXCEPTION("이동할 수 없는 위치입니다.");

    private final String message;

    PositionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
