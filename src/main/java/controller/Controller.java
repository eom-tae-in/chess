package controller;

import domain.board.Board;
import domain.board.generated.ChessBoardGenerator;
import domain.location.Column;
import domain.location.Position;
import domain.location.Row;
import domain.service.Answer;
import dto.BoardResponse;
import dto.MoveStateRequest;
import util.StringConversionHelper;
import view.InputView;
import view.OutputView;

public class Controller {

    private static final int COLUMN = 0;
    private static final int ROW = 1;

    private final InputView inputView;
    private final OutputView outputView;
    private final Answer answer;

    public Controller(final InputView inputView, final OutputView outputView, final Answer answer) {
        this.answer = answer;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Board board = init();
        play(board);
    }

    private void play(final Board board) {
        String state = inputView.receiveGameState();
        while (!answer.isEnd(state)) {
            Board changedBoard = getBoardApplyState(board, state);
            BoardResponse boardResponse = new BoardResponse(changedBoard.getBoard());
            outputView.printBoard(boardResponse);
            state = inputView.receiveGameState();
        }
    }

    private Board getBoardApplyState(final Board board, final String state) {
        if (answer.isStart(state)) {
            return board;
        }
        MoveStateRequest moveStateRequest = MoveStateRequest.from(state);
        return applyMove(board, moveStateRequest);
    }

    private Board applyMove(final Board board, final MoveStateRequest moveStateRequest) {
        Position currentPosition = getPosition(moveStateRequest.getSourcePosition());
        Position nextPosition = getPosition(moveStateRequest.getTargetPosition());
        board.move(currentPosition, nextPosition);
        return board;
    }

    private Position getPosition(final String position) {
        Column columnPosition = Column.getColumn(StringConversionHelper.convertIndexOfStringToString(position, COLUMN));
        Row rowPosition = Row.getRow(StringConversionHelper.convertIndexOfStringToString(position, ROW));
        return Position.of(columnPosition, rowPosition);
    }

    private Board init() {
        outputView.printChessGameStart();
        outputView.printGameRules();
        return createBoard();
    }

    private Board createBoard() {
        ChessBoardGenerator chessBoardGenerator = new ChessBoardGenerator();
        return chessBoardGenerator.create();
    }
}
