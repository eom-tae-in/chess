package dto;

import domain.location.Position;
import domain.piece.ChessPiece;
import domain.piece.Piece;

import java.util.Collections;
import java.util.Map;

public class BoardResponse {
    private final Map<Position, Piece> board;

    public BoardResponse(final Map<Position, Piece> board) {
        this.board = Collections.unmodifiableMap(board);
    }

    public Map<Position, Piece> getBoard() {
        return board;
    }
}
