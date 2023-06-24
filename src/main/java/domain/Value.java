package domain;

import java.util.Objects;

public class Value {

    private final String value;

    public Value(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Value value = (Value) object;
        return Objects.equals(this.value, value.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
