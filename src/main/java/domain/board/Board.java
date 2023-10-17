package domain.board;

import domain.location.Location;
import domain.piece.Piece;
import java.util.Collections;
import java.util.Map;

public class Board {

    private final Map<Location, Piece> board;

    public Board(final Map<Location, Piece> board) {
        this.board = Collections.unmodifiableMap(board);
    }

    public Map<Location, Piece> getBoard() {
        return board;
    }
}
