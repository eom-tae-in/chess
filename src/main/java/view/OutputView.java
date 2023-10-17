package view;

import domain.location.Column;
import domain.location.Location;
import domain.location.Row;
import domain.piece.Piece;
import dto.BoardResponse;
import java.util.Map;

public class OutputView {

    private static final String DOT = ".";
    private static final String CHESS_GAME_START = "체스 게임을 시작합니다.";
    private static final String GAME_START_OR_END = "게임 시작은 start, 종료는 end 명령을 입력하세요.";

    public void printChessGameStart() {
        System.out.println(CHESS_GAME_START);
    }

    public void askGameStartOrEnd() {
        System.out.println(GAME_START_OR_END);
    }

    public void printBoard(final BoardResponse boardResponse) {
        for (Row row : Row.reverse()) {
            printColumnByRow(row, boardResponse);
            printOneLineJump();
        }
        printOneLineJump();
    }

    private void printColumnByRow(final Row row, final BoardResponse boardResponse) {
        Map<Location, Piece> board = boardResponse.getBoard();
        for (Column column : Column.values()) {
            Piece piece = board.get(Location.of(row, column));
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
        if (piece.isBlack()) {
            System.out.print(name.toUpperCase());
            return;
        }
        System.out.print(name.toLowerCase());
    }

    private void printOneLineJump() {
        System.out.println();
    }
}
