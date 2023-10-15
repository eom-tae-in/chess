package domain.piece;

import domain.team.Team;
import domain.location.Position;

public interface Piece {

    Team getTeam();

    String getName();

    void checkCanMove(Position currentPosition, Position nextPosition);
}
