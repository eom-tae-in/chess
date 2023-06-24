package domain;

import domain.location.Row;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RowTest {

    @DisplayName("행의 위치 값을 반환한다.")
    @ParameterizedTest
    @MethodSource("rowAndValueProvider")
    void check_return_row_value(final Row row, final String expected) {
        //when
        String value = row.getValue();

        //then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    private static Stream<Arguments> rowAndValueProvider() {
        return Stream.of(
                Arguments.of(Row.ONE, "1")
                , Arguments.of(Row.TWO, "2")
                , Arguments.of(Row.THREE, "3")
                , Arguments.of(Row.FOUR, "4")
                , Arguments.of(Row.FIVE, "5")
                , Arguments.of(Row.SIX, "6")
                , Arguments.of(Row.SEVEN, "7")
                , Arguments.of(Row.EIGHT, "8")
        );
    }

    @DisplayName("행의 요소들을 역순으로 반환한다.")
    @ParameterizedTest
    @MethodSource("reverseRowProvider")
    void check_return_reverse_array(final List<Row> expected) {
        //when
        List<Row> reverseList = Row.reverse();

        //then
        assertThat(reverseList).isEqualTo(expected);
    }

    private static Stream<Arguments> reverseRowProvider() {
        return Stream.of(
                Arguments.of(List.of(Row.EIGHT, Row.SEVEN, Row.SIX, Row.FIVE, Row.FOUR, Row.THREE, Row.TWO, Row.ONE)
                ));
    }
}
