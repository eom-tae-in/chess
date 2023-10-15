package domain.piece;

import domain.Name;
import domain.location.Column;
import domain.location.Row;
import domain.team.Team;
import domain.location.Position;

import static domain.UnitDistance.SOUTH_EAST;
import static domain.UnitDistance.SOUTH_WEST;
import static domain.UnitDistance.NORTH_EAST;
import static domain.UnitDistance.NORTH_WEST;
import static domain.UnitDistance.SOUTH;
import static domain.UnitDistance.NORTH;
import static exception.PieceMessage.CAN_NOT_MOVE_EXCEPTION;

public class Pawn extends ChessPiece {

    private static final int WHITE_PAWN_INITIAL_MAX_DISTANCE = 2;
    private static final int BLACK_PAWN_INITIAL_MAX_DISTANCE = -2;
    private static final int ZERO = 0;

    public Pawn(final Team team, final Name name) {
        super(team, name);
    }

    @Override
    public void checkCanMove(final Position currentPosition, final Position nextPosition) {
        int columnDistance = Column.calculateDistance(nextPosition.getColumn(), currentPosition.getColumn());
        int rowDistance = Row.calculateDistance(nextPosition.getRow(), currentPosition.getRow());
        checkCanMoveToTarget(currentPosition, nextPosition, columnDistance, rowDistance);
    }

    public void checkCanMoveToTarget(final Position currentPosition, final Position nextPosition, final int columnDistance, final int rowDistance) {
        checkCorrectCommonMovement(nextPosition.getPiece());
        if (isSpecialMovement(columnDistance, rowDistance)) {
            checkCorrectSpecialMovement(columnDistance, rowDistance, currentPosition, nextPosition);
            return;
        }
        if (!isOrdinaryMovement(columnDistance, rowDistance)) {
            throw new AssertionError(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private void checkCorrectCommonMovement(final Piece piece) {
        if (isOurTeamInTargetPosition(piece)) {
            throw new AssertionError(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private boolean isSpecialMovement(final int columnDistance, final int rowDistance) {
        return isInitialMovement(columnDistance, rowDistance) || isDiagonalMovement(columnDistance, rowDistance);
    }


    private void checkCorrectSpecialMovement(final int columnDistance, final int rowDistance, final Position currentPosition, final Position nextPosition) {
        if (isInitialMovement(columnDistance, rowDistance)) {
            checkHasMoved(currentPosition);
            return;
        }
        if (isDiagonalMovement(columnDistance, rowDistance)) {
            checkHasSomeoneIn(nextPosition);
        }
    }

    private boolean isOrdinaryMovement(final int columnDistance, final int rowDistance) {
        if (getTeam() == Team.BLACK) {
            return SOUTH.getMoveColumn() == columnDistance && SOUTH.getMoveRow() == rowDistance;
        }
        return SOUTH.getMoveColumn() == columnDistance && NORTH.getMoveRow() == rowDistance;
    }

    private boolean isInitialMovement(final int columnDistance, final int rowDistance) {
        if (getTeam() == Team.BLACK) {
            return (columnDistance == ZERO && rowDistance == BLACK_PAWN_INITIAL_MAX_DISTANCE);
        }
        return (columnDistance == ZERO && rowDistance == WHITE_PAWN_INITIAL_MAX_DISTANCE);
    }

    private void checkHasMoved(final Position position) {
        if (position.hasMoved(position.getCoordinate())) {
            throw new AssertionError(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }

    private boolean isDiagonalMovement(final int columnDistance, final int rowDistance) {
        if (getTeam() == Team.BLACK) {
            return (SOUTH_EAST.getMoveColumn() == columnDistance && SOUTH_EAST.getMoveRow() == rowDistance)
                    || (SOUTH_WEST.getMoveColumn() == columnDistance && SOUTH_WEST.getMoveRow() == rowDistance);
        }
        return (NORTH_WEST.getMoveColumn() == columnDistance && NORTH_WEST.getMoveRow() == rowDistance)
                || (NORTH_EAST.getMoveColumn() == columnDistance && NORTH_EAST.getMoveRow() == rowDistance);
    }

    private void checkHasSomeoneIn(final Position nextPosition) {
        if (!nextPosition.hasSomeone()) {
            throw new AssertionError(CAN_NOT_MOVE_EXCEPTION.getMessage());
        }
    }
}
