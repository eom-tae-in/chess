package util;

import static exception.InputMessage.WRONG_INPUT;

public class StringValidator {

    public static void validation(final String text) {
        checkNull(text);
        checkBlank(text);
    }

    private static void checkNull(final String text) {
        if (text == null) {
            throw new NullPointerException(WRONG_INPUT.getMessage());
        }
    }

    private static void checkBlank(final String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException(WRONG_INPUT.getMessage());
        }
    }
}
