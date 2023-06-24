package domain.location;

import domain.Value;

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
}
