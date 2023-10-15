package domain;

public class Value {

    private final String value;

    public Value(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getStringWithIndex(int index) {
        return String.valueOf(value.charAt(index));
    }
}
