package com.example.soccer_week_11;

import java.util.Arrays;
import java.util.List;

import java.util.Arrays;
import java.util.List;

public class DataProvider {

    // 球队数据提供
    public static List<Team> getTeams() {
        return Arrays.asList(
                new Team("London Lions", "Coach Wilson"),
                new Team("Paris Panthers", "Coach Martin"),
                new Team("Berlin Bears", "Coach Harrison")
        );
    }

    // 球员数据提供
    public static List<Player> getPlayers() {
        return Arrays.asList(
                new Player("James Carter", "Forward"),
                new Player("Oliver Davies", "Center Back"),
                new Player("Ethan Wilson", "Attacking Midfielder")
        );
    }

    // 赛事数据提供
    public static List<Match> getMatches() {
        return Arrays.asList(
                new Match("Berlin Bears", "London Lions", "2024-06-10"),
                new Match("Paris Panthers", "Berlin Bears", "2024-07-15"),
                new Match("London Lions", "Paris Panthers", "2024-08-20")
        );
    }
}

