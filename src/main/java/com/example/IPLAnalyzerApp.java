package com.example;

import com.example.model.Match;
import com.example.service.CensorService;
import com.example.util.JSONHandler;
import com.example.util.CSVHandler;

import java.util.List;

public class IPLAnalyzerApp {

    public static void main(String[] args) {

        try {

            // 1 Read JSON
            List<Match> jsonMatches =
                    JSONHandler.readJSON("src/main/resources/input.json");

            // 2 Apply censorship
            CensorService.applyCensorship(jsonMatches);

            // 3 Write JSON output
            JSONHandler.writeJSON("censored.json", jsonMatches);


            // 4 Read CSV
            List<Match> csvMatches =
                    CSVHandler.readCSV("src/main/resources/input.csv");

            // 5 Apply censorship
            CensorService.applyCensorship(csvMatches);

            // 6 Write CSV output
            CSVHandler.writeCSV("censored.csv", csvMatches);


            System.out.println("Processing Completed Successfully");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}