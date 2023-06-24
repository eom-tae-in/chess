package controller;

import domain.board.Board;
import domain.board.generated.ChessBoardGenerator;
import dto.BoardResponse;
import domain.Answer;
import view.InputView;
import view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Board board = createBoard();
        outputView.printChessGameStart();
        outputView.askGameStartOrEnd();
        while (Answer.isStart(inputView.receiveGameState())) {
            outputView.printBoard(new BoardResponse(board.getBoard()));
        }
    }

    private Board createBoard() {
        ChessBoardGenerator chessBoardGenerator = new ChessBoardGenerator();
        return chessBoardGenerator.create();
    }
}
