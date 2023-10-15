package domain.team;

import java.util.List;

public enum TeamOfGame {
    CHESS(List.of(Team.WHITE, Team.BLACK));

    private final List<Team> teams;

    TeamOfGame(final List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
