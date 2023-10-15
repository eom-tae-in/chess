package domain.piece;

import domain.Name;
import domain.team.Team;

public abstract class ChessPiece implements Piece {

    private final Team team;
    private final Name name;

    public ChessPiece(final Team team, final Name name) {
        this.team = team;
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name.getName();
    }

    public boolean isBlack() {
        return team == Team.BLACK;
    }

    public boolean isOurTeamInTargetPosition(final Piece piece) {
        return piece != null && this.getTeam() == piece.getTeam();
    }
}

