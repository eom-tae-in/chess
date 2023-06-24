package domain;

import util.StringValidator;
import static exception.InputMessage.WRONG_INPUT;

public class Answer {

    private static final String START = "start";
    private static final String END = "end";

    public static boolean isStart(final String answer) {
        return answer.equals(START);
    }

    public static void validation(final String answer) {
        StringValidator.validation(answer);
        checkAnswerStartOrEnd(answer);
    }

    private static void checkAnswerStartOrEnd(final String answer) {
        if (!answer.equals(START) && !answer.equals(END)) {
            throw new IllegalArgumentException(WRONG_INPUT.getMessage());
        }
    }
}
