package domain.piece;

import domain.Name;
import domain.location.Column;
import domain.location.Coordinate;
import domain.location.Row;
import domain.team.Team;
import domain.location.Position;

import static exception.PieceMessage.CAN_NOT_MOVE_EXCEPTION;

public class Knight extends ChessPiece {

    private static final int ONE_SPACE = 1;
    private static final int TWO_SPACE = 2;

    public Knight(final Team team, final Name name) {
        super(team, name);
    }

    @Override
    public void checkCanMove(final Position currentPosition, final Position nextPosition) {
        int columnDistance = Column.calculateDistance(nextPosition.getColumn(), currentPosition.getColumn());
        int rowDistance = Row.calculateDistance(nextPosition.getRow(), currentPosition.getRow());
        checkCanMoveToTarget(nextPosition.getPiece(), columnDistance, rowDistance);
    }

    private void checkCanMoveToTarget(final Piece piece, final int columnDistance, final int rowDistance) {
        if (!isCorrectMovement(rowDistance, columnDistance) || isOurTeamInTargetPosition(piece)) {
            throw new AssertionError(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private boolean isCorrectMovement(final int rowDistance, final int columnDistance) {
        int absoluteRow = Math.abs(rowDistance);
        int absoluteColumn = Math.abs(columnDistance);

        return (absoluteRow == TWO_SPACE && absoluteColumn == ONE_SPACE) || (absoluteRow == ONE_SPACE && absoluteColumn == TWO_SPACE);
    }
}
