package domain.piece;

import domain.Name;
import domain.location.Column;
import domain.location.Row;
import domain.team.Team;
import domain.location.Position;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static exception.PieceMessage.CAN_NOT_MOVE_EXCEPTION;

public class Bishop extends ChessPiece {

    private static final int CURRENT_POSITION = 0;
    private static final int ONE_SPACE = 1;

    public Bishop(final Team team, final Name name) {
        super(team, name);
    }

    @Override
    public void checkCanMove(final Position currentPosition, final Position nextPosition) {
        int columnDistance = Column.calculateDistance(nextPosition.getColumn(), currentPosition.getColumn());
        int rowDistance = Row.calculateDistance(nextPosition.getRow(), currentPosition.getRow());
        checkCanMoveToTarget(currentPosition, nextPosition.getPiece(), columnDistance, rowDistance);
    }

    public void checkCanMoveToTarget(final Position currentPosition, final Piece piece, final int columnDistance, final int rowDistance) {
        int sourceToBeforeTargetDistance = Math.abs(columnDistance) - ONE_SPACE;
        if (!isCorrectMovement(columnDistance, rowDistance) || !canMoveBeforeTargetPosition(currentPosition, sourceToBeforeTargetDistance)
                || isOurTeamInTargetPosition(piece)) {

            throw new NoSuchElementException(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private boolean canMoveBeforeTargetPosition(final Position currentPosition, final int sourceToTargetDistance) {
        Column currentColumn = currentPosition.getColumn();
        Row currentRow = currentPosition.getRow();
        return IntStream.range(CURRENT_POSITION, sourceToTargetDistance)
                .noneMatch(distance -> hasSomeoneInPosition(currentColumn, currentRow, distance));
    }

    private boolean hasSomeoneInPosition(final Column column, final Row row, final int distance) {
        Position position = Position.of(column.awayFrom(distance), row.awayFrom(distance));
        return position.hasSomeone();
    }

    private boolean isCorrectMovement(final int columnDistance, final int rowDistance) {
        return rowDistance == columnDistance || -rowDistance == columnDistance;
    }
}
