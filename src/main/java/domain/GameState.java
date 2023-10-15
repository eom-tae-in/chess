package domain;

public enum GameState {

    START("start"),
    MOVE("move"),
    END("end");

    private final String answer;

    GameState(final String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
