package view;

import domain.location.Column;
import domain.location.Position;
import domain.location.Row;
import domain.piece.Piece;
import domain.team.Team;
import dto.BoardResponse;

import java.util.Map;

public class OutputView {

    private static final String DOT = ".";
    private static final String CHESS_GAME_START_PHASE = "> 체스 게임을 시작합니다.";
    private static final String GAME_START_PHASE = "> 게임 시작 : start";
    private static final String GAME_END_PHASE = "> 게임 종료 : end";
    private static final String GAME_MOVE_PHASE = "> 게임 이동 : move source위치 target위치 - 예. move b2 b3";

    public void printChessGameStart() {
        System.out.println(CHESS_GAME_START_PHASE);
    }

    public void printGameRules() {
        System.out.println(GAME_START_PHASE);
        System.out.println(GAME_END_PHASE);
        System.out.println(GAME_MOVE_PHASE);
    }

    public void printBoard(final BoardResponse boardResponse) {
        for (Row row : Row.reverse()) {
            printColumnByRow(row, boardResponse);
            printOneLineJump();
        }
        printOneLineJump();
    }

    private void printColumnByRow(final Row row, final BoardResponse boardResponse) {
        Map<Position, Piece> board = boardResponse.getBoard();
        for (Column column : Column.values()) {
            Piece piece = board.get(Position.of(column, row));
            printSpace(piece);
        }
    }

    private void printSpace(final Piece piece) {
        if (piece != null) {
            printPiece(piece);
            return;
        }
        System.out.print(DOT);
    }

    private void printPiece(final Piece piece) {
        String name = piece.getName();
        if (piece.getTeam() == Team.BLACK) {
            System.out.print(name.toUpperCase());
            return;
        }
        System.out.print(name.toLowerCase());
    }

    private void printOneLineJump() {
        System.out.println();
    }
}
