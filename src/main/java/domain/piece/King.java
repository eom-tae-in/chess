package domain.piece;

import domain.Name;
import domain.location.Column;
import domain.location.Row;
import domain.team.Team;
import domain.UnitDistance;
import domain.location.Position;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static exception.PieceMessage.CAN_NOT_MOVE_EXCEPTION;

public class King extends ChessPiece {

    public King(final Team team, final Name name) {
        super(team, name);
    }

    @Override
    public void checkCanMove(final Position currentPosition, final Position nextPosition) {
        int columnDistance = Column.calculateDistance(nextPosition.getColumn(), currentPosition.getColumn());
        int rowDistance = Row.calculateDistance(nextPosition.getRow(), currentPosition.getRow());
        checkCanMoveToTarget(nextPosition.getPiece(), columnDistance, rowDistance);
    }

    public void checkCanMoveToTarget(final Piece piece, final int columnDistance, final int rowDistance) {
        if (isCorrectMovement(columnDistance, rowDistance) || isOurTeamInTargetPosition(piece)) {
            throw new NoSuchElementException(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private boolean isCorrectMovement(final int columnDistance, final int rowDistance) {
        return Arrays.stream(UnitDistance.values())
                .anyMatch(unitDistance -> columnDistance == unitDistance.getMoveColumn() && rowDistance == unitDistance.getMoveRow());
    }
}
