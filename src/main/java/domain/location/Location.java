package domain.location;

import domain.Value;
import java.util.HashMap;
import java.util.Map;

public class Location {

    private static final Map<Value, Location> cache = new HashMap<>();
    private final Row row;
    private final Column column;

    private Location(final Row row, final Column column) {
        this.row= row;
        this.column = column;

    }

    public static Location of(final Row row, final Column column) {
        Value value = new Value(column.getValue() + row.getValue());
        if (cache.get(value) == null) {
            cache.put(value, new Location(row, column));
        }
        return cache.get(value);
    }
}

