package com.example.soccer_week_11;

import java.io.Serializable;

public class Player implements SoccerEntity, Serializable {
    private final String name;
    private final String position;

    public Player(String name, String position) {
        if (name == null || position == null) throw new IllegalArgumentException("Invalid player data");
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getDisplayName() {
        return name + " - " + position;
    }
}
