package domain.service;

import domain.GameState;
import domain.location.Column;
import domain.location.Row;
import util.StringValidator;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static domain.GameState.START;
import static domain.GameState.MOVE;
import static domain.GameState.END;
import static exception.InputMessage.WRONG_INPUT;
import static util.StringConversionHelper.*;

public class Answer {

    private static final int WORD_SEGMENT_SIZE_OF_MOVE = 3;
    private static final int STATE_VALUE = 0;
    private static final int SOURCE_POSITION_VALUE = 1;
    private static final int TARGET_POSITION_VALUE = 2;
    private static final int LENGTH_OF_POSITION = 2;
    private static final int COLUMN = 0;
    private static final int ROW = 1;
    private static final String BLANK = " ";

    public boolean isStart(final String answer) {
        return answer.equals(START.getAnswer());
    }

    public boolean isEnd(final String answer) {
        return answer.equals(END.getAnswer());
    }

    public boolean isStartWithMove(final String answer) {
        return answer.startsWith(MOVE.getAnswer());
    }

    public void validation(final String answer) {
        List<String> wordSegments = List.of(answer.split(BLANK));
        StringValidator.validation(answer);
        checkAnswerState(wordSegments.get(STATE_VALUE));
        if (isStartWithMove(answer)) {
            checkMoveFormat(wordSegments);
        }
    }

    private void checkAnswerState(final String state) {
        Arrays.stream(GameState.values())
                .filter(gameState -> state.equals(gameState.getAnswer()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(WRONG_INPUT.getMessage()));
    }

    public void checkMoveFormat(final List<String> wordSegments) {
        checkPositionInfoFormat(wordSegments);
        checkPosition(wordSegments.get(SOURCE_POSITION_VALUE));
        checkPosition(wordSegments.get(TARGET_POSITION_VALUE));
    }

    private void checkPositionInfoFormat(final List<String> wordSegments) {
        if (!isCorrectFormatSize(wordSegments)) {
            throw new AssertionError(WRONG_INPUT.getMessage());
        }
    }

    private static boolean isCorrectFormatSize(final List<String> wordSegments) {
        return wordSegments.size() == WORD_SEGMENT_SIZE_OF_MOVE;
    }

    private void checkPosition(final String position) {
        checkPositionSize(position);
        Column.getColumn(convertIndexOfStringToString(position, COLUMN));
        Row.getRow(convertIndexOfStringToString(position, ROW));
    }

    private void checkPositionSize(final String position) {
        if (!isCorrectPositionSize(position)) {
            throw new AssertionError(WRONG_INPUT.getMessage());
        }
    }

    private boolean isCorrectPositionSize(final String position) {
        return position.length() == LENGTH_OF_POSITION;
    }
}

