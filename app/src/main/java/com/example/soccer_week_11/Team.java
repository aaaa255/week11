package com.example.soccer_week_11;

import java.io.Serializable;

public class Team implements SoccerEntity, Serializable {
    private final String name;
    private final String coach;

    public Team(String name, String coach) {
        if (name == null || coach == null) throw new IllegalArgumentException("Invalid team data");
        this.name = name;
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    @Override
    public String getDisplayName() {
        return name + " (Coach: " + coach + ")";
    }
}
