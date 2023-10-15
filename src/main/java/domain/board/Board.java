package domain.board;

import domain.location.Position;
import domain.piece.Piece;

import java.util.Collections;
import java.util.Map;

public class Board {

    private final Map<Position, Piece> board;

    public Board(final Map<Position, Piece> board) {
        this.board = board;
    }

    public Map<Position, Piece> getBoard() {
        return Collections.unmodifiableMap(board);
    }

    public void move(final Position currentPosition, final Position nextPosition) {
        Piece currentPiece = currentPosition.getPiece();
        currentPiece.checkCanMove(currentPosition, nextPosition);
        board.remove(currentPosition);
        currentPosition.change(currentPosition, nextPosition);
        board.put(nextPosition, currentPiece);
    }
}
