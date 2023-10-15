package domain.location;

import domain.Value;

import java.util.Arrays;
import java.util.NoSuchElementException;
import static exception.PositionMessage.COLUMN_NOT_FOUND_EXCEPTION;

public enum Column {

    A(new Value("a")),
    B(new Value("b")),
    C(new Value("c")),
    D(new Value("d")),
    E(new Value("e")),
    F(new Value("f")),
    G(new Value("g")),
    H(new Value("h"));

    private final Value value;

    Column(final Value value) {
        this.value = value;
    }

    public String getValue() {
        return value.getValue();
    }

    public static Column getColumn(final String value) {
        return Arrays.stream(values())
                .filter(column -> column.value.getValue().equals(value))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(COLUMN_NOT_FOUND_EXCEPTION.getMessage()));
    }

    public Column awayFrom(int index) {
        int nextIndex = ordinal() + index;
        return values()[nextIndex];
    }

    public static int calculateDistance(final Column nextColumn, final Column currentColumn) {
        return nextColumn.ordinal() - currentColumn.ordinal();
    }
}
