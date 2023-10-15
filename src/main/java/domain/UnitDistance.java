package domain;


public enum UnitDistance {


    NORTH(1, 0),
    NORTH_EAST(1, 1),
    EAST(0, 1),
    SOUTH_EAST(-1, 1),
    SOUTH(-1, 0),
    SOUTH_WEST(-1, -1),
    WEST(0, -1),
    NORTH_WEST(1, -1);

    private final int moveRow;
    private final int moveColumn;

    UnitDistance(final int moveRow, final int moveColumn) {
        this.moveRow = moveRow;
        this.moveColumn = moveColumn;
    }

    public int getMoveRow() {
        return moveRow;
    }

    public int getMoveColumn() {
        return moveColumn;
    }
}
