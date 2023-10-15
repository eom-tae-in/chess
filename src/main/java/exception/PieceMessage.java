package exception;

public enum PieceMessage {

    NOT_FOUND_PIECE_EXCEPTION("기물을 찾을 수 없습니다."),
    CAN_NOT_MOVE_EXCEPTION("해당 위치로 이동할 수 없습니다.");

    private final String message;

    PieceMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
