package com.example.soccer_week_11;

import java.io.Serializable;

public class Match implements SoccerEntity, Serializable {
    private final String teamA;
    private final String teamB;
    private final String date;

    public Match(String teamA, String teamB, String date) {
        if (teamA == null || teamB == null || date == null) throw new IllegalArgumentException("Invalid match data");
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String getDisplayName() {
        return teamA + " vs " + teamB + " on " + date;
    }
}
