package dto;

import domain.location.Location;
import domain.piece.Piece;
import java.util.Collections;
import java.util.Map;

public class BoardResponse {

    private final Map<Location, Piece> board;

    public BoardResponse(final Map<Location, Piece> board) {
        this.board = Collections.unmodifiableMap(board);
    }

    public Map<Location, Piece> getBoard() {
        return board;
    }
}
