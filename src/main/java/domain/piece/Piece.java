package domain.piece;

import domain.Name;
import domain.Team;

public class Piece {

    private final Team team;
    private final Name name;

    public Piece(final Team team, final Name name) {
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
}

