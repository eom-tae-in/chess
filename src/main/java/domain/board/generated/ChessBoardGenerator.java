package domain.board.generated;

import domain.Name;
import domain.piece.Piece;
import domain.team.Team;
import domain.board.Board;
import domain.location.Position;
import domain.location.Row;
import domain.location.Column;
import domain.piece.Bishop;
import domain.piece.King;
import domain.piece.Knight;
import domain.piece.Pawn;
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

    private final Map<Position, Piece> board = new HashMap<>();


    @Override
    public Board create() {
        initBlackPieces();
        initWhitePieces();
        return new Board(board);
    }

    private void initBlackPieces() {
        initRook(Row.EIGHT, Team.BLACK);
        initKnight(Row.EIGHT, Team.BLACK);
        initBishop(Row.EIGHT, Team.BLACK);
        initKing(Row.EIGHT, Team.BLACK);
        initQueen(Row.EIGHT, Team.BLACK);
        initPawn(Row.SEVEN, Team.BLACK);
    }

    private void initWhitePieces() {
        initRook(Row.ONE, Team.WHITE);
        initKnight(Row.ONE, Team.WHITE);
        initBishop(Row.ONE, Team.WHITE);
        initKing(Row.ONE, Team.WHITE);
        initQueen(Row.ONE, Team.WHITE);
        initPawn(Row.TWO, Team.WHITE);
    }

    private void initRook(final Row row,  final Team team) {
        Rook rook = new Rook(team, new Name(ROOK));
        board.put(Position.of(Column.A, row, rook), rook);
        board.put(Position.of(Column.H, row, rook), rook);
    }

    private void initKnight(final Row row, final Team team) {
        Knight knight = new Knight(team, new Name(KNIGHT));
        board.put(Position.of(Column.B, row, knight), knight);
        board.put(Position.of(Column.G, row, knight), knight);
    }

    private void initBishop(final Row row, final Team team) {
        Bishop bishop = new Bishop(team, new Name(BISHOP));
        board.put(Position.of(Column.C, row, bishop), bishop);
        board.put(Position.of(Column.F, row, bishop), bishop);
    }

    private void initKing(final Row row,  final Team team) {
        King king = new King(team, new Name(KING));
        board.put(Position.of(Column.E, row, king), king);
    }

    private void initQueen(final Row row, final Team team) {
        Queen queen = new Queen(team, new Name(QUEEN));
        board.put(Position.of(Column.D, row, queen), queen);
    }

    private void initPawn(final Row row,  final Team team) {
        Pawn pawn = new Pawn(team, new Name(PAWN));
        Arrays.stream(Column.values())
                .forEach(column -> board.put(Position.of(column, row, pawn), pawn));
    }
}
