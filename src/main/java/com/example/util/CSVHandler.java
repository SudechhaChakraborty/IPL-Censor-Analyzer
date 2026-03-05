package com.example.util;

import com.example.model.Match;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    public static List<Match> readCSV(String path) throws Exception {

        CSVReader reader = new CSVReader(new FileReader(path));
        List<String[]> rows = reader.readAll();

        List<Match> matches = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {

            String[] row = rows.get(i);

            Match m = new Match();
            m.setMatch_id(Integer.parseInt(row[0]));
            m.setTeam1(row[1]);
            m.setTeam2(row[2]);
            m.setWinner(row[5]);
            m.setPlayer_of_match(row[6]);

            matches.add(m);
        }

        return matches;
    }

    public static void writeCSV(String path, List<Match> matches) throws Exception {

        CSVWriter writer = new CSVWriter(new FileWriter(path));

        writer.writeNext(new String[]{
                "match_id","team1","team2","winner","player_of_match"
        });

        for (Match m : matches) {

            writer.writeNext(new String[]{
                    String.valueOf(m.getMatch_id()),
                    m.getTeam1(),
                    m.getTeam2(),
                    m.getWinner(),
                    m.getPlayer_of_match()
            });
        }

        writer.close();
    }
}