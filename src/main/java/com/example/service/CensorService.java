package com.example.service;

import com.example.model.Match;
import java.util.List;

public class CensorService {

    public static void applyCensorship(List<Match> matches) {

        for (Match match : matches) {

            match.setTeam1(maskTeam(match.getTeam1()));
            match.setTeam2(maskTeam(match.getTeam2()));

            match.setPlayer_of_match("REDACTED");
        }
    }

    private static String maskTeam(String team) {

        if (team == null) return team;

        String[] parts = team.split(" ");

        if (parts.length > 1) {
            return parts[0] + " ***";
        }

        return "***";
    }
}