package domain;

import domain.location.Column;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ColumnTest {

    @DisplayName("열의 위치 값을 반환한다.")
    @ParameterizedTest
    @MethodSource("columnAndValueProvider")
    void check_return_column_value(final Column column, final String expected) {
        //when
        String value = column.getValue();

        //then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    private static Stream<Arguments> columnAndValueProvider() {
        return Stream.of(
                Arguments.of(Column.A, "a")
                , Arguments.of(Column.B, "b")
                , Arguments.of(Column.C, "c")
                , Arguments.of(Column.D, "d")
                , Arguments.of(Column.E, "e")
                , Arguments.of(Column.F, "f")
                , Arguments.of(Column.G, "g")
                , Arguments.of(Column.H, "h")
        );
    }
}
