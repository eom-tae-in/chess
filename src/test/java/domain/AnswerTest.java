package domain;

import domain.service.Answer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @DisplayName("문자가 start이면 true를 반환하고 start가 아니면 false를 반환한다.")
    @ParameterizedTest
    @MethodSource("answerAndBooleanProvider")
    void check_text_start_return_turn_if_not_return_false(final String text, final boolean expected) {
        //when
        boolean result = Answer.isStart(text);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> answerAndBooleanProvider() {
        return Stream.of(
                Arguments.of("", false)
                , Arguments.of(" ", false)
                , Arguments.of("test", false)
                , Arguments.of("end", false)
                , Arguments.of("start", true)
        );
    }

    @DisplayName("문자가 올바르지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("answerAndExceptionProvider")
    void check_text_if_incorrect_throw_exception(final String text, final Class<?> expectedException) {
        //when //then
        Assertions.assertThatThrownBy(() -> Answer.validation(text))
                .isInstanceOf(expectedException);
    }

    private static Stream<Arguments> answerAndExceptionProvider() {
        return Stream.of(
                Arguments.of("", IllegalArgumentException.class)
                , Arguments.of(" ", IllegalArgumentException.class)
                , Arguments.of(null, NullPointerException.class)
                , Arguments.of("test", IllegalArgumentException.class)
        );
    }
}
