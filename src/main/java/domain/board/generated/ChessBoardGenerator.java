package domain.board.generated;

import domain.Name;
import domain.Team;
import domain.board.Board;
import domain.location.Row;
import domain.location.Location;
import domain.location.Column;
import domain.piece.Bishop;
import domain.piece.King;
import domain.piece.Knight;
import domain.piece.Pawn;
import domain.piece.Piece;
import domain.piece.Queen;
import domain.piece.Rook;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChessBoardGenerator implements BoardGenerator {

    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String BISHOP = "B";
    private static final String KNIGHT = "N";
    private static final String ROOK = "R";
    private static final String PAWN = "P";


    @Override
    public Board create() {
        Map<Location, Piece> board = new HashMap<>();
        initBlackPieces(board);
        initWhitePieces(board);
        return new Board(board);
    }

    private void initBlackPieces(final Map<Location, Piece> board) {
        initRook(Row.EIGHT, board, Team.BLACK);
        initKnight(Row.EIGHT, board, Team.BLACK);
        initBishop(Row.EIGHT, board, Team.BLACK);
        initKing(Row.EIGHT, board, Team.BLACK);
        initQueen(Row.EIGHT, board, Team.BLACK);
        initPawn(Row.SEVEN, board, Team.BLACK);
    }

    private void initWhitePieces(final Map<Location, Piece> board) {
        initRook(Row.ONE, board, Team.WHITE);
        initKnight(Row.ONE, board, Team.WHITE);
        initBishop(Row.ONE, board, Team.WHITE);
        initKing(Row.ONE, board, Team.WHITE);
        initQueen(Row.ONE, board, Team.WHITE);
        initPawn(Row.TWO, board, Team.WHITE);
    }

    private void initRook(final Row column, final Map<Location, Piece> board, final Team team) {
        board.put(Location.of(column, Column.A), new Rook(team, new Name(ROOK)));
        board.put(Location.of(column, Column.H), new Rook(team, new Name(ROOK)));
    }

    private void initKnight(final Row column, final Map<Location, Piece> board, final Team team) {
        board.put(Location.of(column, Column.B), new Knight(team, new Name(KNIGHT)));
        board.put(Location.of(column, Column.G), new Knight(team, new Name(KNIGHT)));
    }

    private void initBishop(final Row column, final Map<Location, Piece> board, final Team team) {
        board.put(Location.of(column, Column.C), new Bishop(team, new Name(BISHOP)));
        board.put(Location.of(column, Column.F), new Bishop(team, new Name(BISHOP)));
    }

    private void initKing(final Row column, final Map<Location, Piece> board, final Team team) {
        board.put(Location.of(column, Column.E), new King(team, new Name(KING)));
    }

    private void initQueen(final Row column, final Map<Location, Piece> board, final Team team) {
        board.put(Location.of(column, Column.D), new Queen(team, new Name(QUEEN)));
    }

    private void initPawn(final Row column, final Map<Location, Piece> board, final Team team) {
        Arrays.stream(Column.values())
                .forEach(row -> board.put(Location.of(column, row), new Pawn(team, new Name(PAWN))));
    }
}
