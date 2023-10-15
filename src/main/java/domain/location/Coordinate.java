package domain.location;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {

    private static final Map<String, Coordinate> cache = new HashMap<>();

    private final Column column;
    private final Row row;

    private Coordinate(final Column column, final Row row) {
        this.column = column;
        this.row = row;
    }

    public Column getColumn() {
        return column;
    }

    public Row getRow() {
        return row;
    }

    public static Coordinate of(final Column column, final Row row) {
        String key = makeKey(column, row);
        if (!cache.containsKey(key)) {
            cache.put(key, new Coordinate(column, row));
        }
        return cache.get(key);
    }



    public static String makeKey(Column column, Row row) {
        return column.getValue() + row.getValue();
    }
}
