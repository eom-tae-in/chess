package domain.location;

import domain.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static exception.PositionMessage.ROW_NOT_FOUND_EXCEPTION;

public enum Row {

    ONE(new Value("1")),
    TWO(new Value("2")),
    THREE(new Value("3")),
    FOUR(new Value("4")),
    FIVE(new Value("5")),
    SIX(new Value("6")),
    SEVEN(new Value("7")),
    EIGHT(new Value("8"));

    private final Value value;

    Row(final Value value) {
        this.value = value;
    }

    public String getValue() {
        return value.getValue();
    }

    public static List<Row> reverse() {
        List<Row> rowList = Arrays.asList(values());
        Collections.reverse(rowList);
        return rowList;
    }

    public static Row getRow(final String value) {
        return Arrays.stream(values())
                .filter(row -> row.value.getValue().equals(value))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(ROW_NOT_FOUND_EXCEPTION.getMessage()));
    }

    public Row awayFrom(int index) {
        int nextIndex = ordinal() + index;
        return values()[nextIndex];
    }

    public static int calculateDistance(final Row nextRow, final Row currentRow) {
        return nextRow.ordinal() - currentRow.ordinal();
    }
}
