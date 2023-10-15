package domain.location;

import domain.piece.Piece;
import util.StringConversionHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static exception.PieceMessage.NOT_FOUND_PIECE_EXCEPTION;

public class Position {

    private static final int COLUMN_INDEX = 0;
    private static final int ROW_INDEX = 1;
    private static final Map<String, Position> cache = new HashMap<>();

    private final Coordinate coordinate;
    private Piece piece;

    private Position(final Coordinate coordinate, final Piece piece) {
        this.coordinate = coordinate;
        this.piece = piece;
    }

    private Position(final Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean hasMoved(final Coordinate coordinate) {
        String key = findKey(coordinate);
        Column column = Column.getColumn(StringConversionHelper.convertIndexOfStringToString(key, COLUMN_INDEX));
        Row row = Row.getRow(StringConversionHelper.convertIndexOfStringToString(key, ROW_INDEX));
        return !coordinate.equals(Coordinate.of(column, row));
    }

    // Position 생성 및 Position 수정
    public static Position of(final Column column, final Row row, final Piece piece) {
        Coordinate coordinate = Coordinate.of(column, row);
        try {
            Position position = cache.get(findKey(coordinate));
            position.setPiece(piece);
            return position;
        } catch (NoSuchElementException e) {
            Position position = new Position(coordinate, piece);
            cache.put(Coordinate.makeKey(column, row), position);
            return position;
        }
    }

    // Position 조회
    public static Position of(final Column column, final Row row) {
        Coordinate coordinate = Coordinate.of(column, row);
        try {
            return cache.get(findKey(coordinate));
        } catch (NoSuchElementException e) {
            String key = Coordinate.makeKey(column, row);
            cache.put(key, new Position(coordinate));
            return cache.get(key);
        }
    }

    private static String findKey(final Coordinate coordinate) {
        return cache.entrySet().stream()
                .filter(position -> coordinate.equals(position.getValue().getCoordinate()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_PIECE_EXCEPTION.getMessage()))
                .getKey();
    }

    public void change(final Position currentPosition, final Position nextPosition) {
        String currentKey = findKey(currentPosition.getCoordinate());
        String nextKey = findKey(nextPosition.getCoordinate());
        if (nextPosition.hasSomeone()) {
            removePieceAndMove(currentPosition, nextPosition, currentKey, nextKey);
            return;
        }
        swap(currentPosition, nextPosition, currentKey, nextKey);
    }

    private void removePieceAndMove(final Position currentPosition, final Position nextPosition, final String currentKey, final String nextKey) {

        changePosition(currentKey, nextPosition.getColumn(), nextPosition.getRow(), currentPosition.getPiece());
        cache.put(nextKey, currentPosition);
        changePosition(nextKey, currentPosition.getColumn(), currentPosition.getRow(), null);
    }

    private void swap(final Position currentPosition, final Position nextPosition, final String currentKey, final String nextKey) {
        changePosition(currentKey, nextPosition.getColumn(), nextPosition.getRow(), currentPosition.getPiece());
        currentPosition.piece = null;
        cache.put(nextKey, currentPosition);
        changePosition(nextKey, currentPosition.getColumn(), currentPosition.getRow(), nextPosition.getPiece());
    }

    private void changePosition(final String key, final Column nextColumn, final Row nextRow, final Piece piece) {
        cache.put(key, Position.of(nextColumn, nextRow, piece));
    }

    public boolean hasSomeone() {
        return piece != null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public Row getRow() {
        return coordinate.getRow();
    }

    public Column getColumn() {
        return coordinate.getColumn();
    }

    private void setPiece(final Piece piece) {
        this.piece = piece;
    }
}

