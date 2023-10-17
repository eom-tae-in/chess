package domain.location;

import domain.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
